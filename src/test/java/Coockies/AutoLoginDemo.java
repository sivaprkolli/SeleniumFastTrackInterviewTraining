package Coockies;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class AutoLoginDemo {

    WebDriver driver;
    WebDriverWait webDriverWait;
    private WebStorage webStorage;

    @BeforeTest
    public void launchApp(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        webStorage = (WebStorage) new Augmenter().augment(driver);

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }


    @Test
    public void autoLogin() throws InterruptedException {
        SessionManager sessionManager = new SessionManager(driver);
        sessionManager.usePreviousLoggedInSession("tricentis1");
        Thread.sleep(5000);
    }

    @Test
    public void loginToEP() throws IOException, InterruptedException {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='/login']"))).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Email"))).sendKeys("autotest@yopmail.com");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Password"))).sendKeys("Test@123");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Log in']"))).click();
        Thread.sleep(5000);
        storeSessionFile("tricentis1", "autotest@yopmail.com");
    }

    @AfterTest
    public void killSession(){
        driver.quit();
    }

    // Store Session Data in a File If login success for each time
    public void storeSessionFile(String fileName,String userName) throws IOException {
        if (Files.exists(Paths.get(System.getProperty("user.dir") + "/"+fileName+".json"))) {
            Files.deleteIfExists(Paths.get(System.getProperty("user.dir") + "/"+fileName+".json"));
        }

        JSONObject sessionObj = new JSONObject();
        sessionObj.put("username", userName);// Optional
        sessionObj.put("createdAt", LocalDateTime.now()); // Optional
        sessionObj.put("session_data", getSessionData());

        System.out.println(" JSON Obj : " + sessionObj);
        JSONUtils.writeJSONObjectToFile(sessionObj, "./"+fileName+".json");
    }

    // Get Session Data
    private JSONObject getSessionData() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("session_storage", getSessionStorageData());
        jsonObject.put("local_storage", getLocalStorageData());
        jsonObject.put("cookies", getCookiesData());
        return jsonObject;
    }

    // Get Local storage
    private JSONObject getLocalStorageData() {
        LocalStorage localStorage = webStorage.getLocalStorage();
        JSONObject localStorageJsonObj = new JSONObject();
        localStorage.keySet().stream()
                .forEach(x -> localStorageJsonObj.put(x, localStorage.getItem(x)));
        return localStorageJsonObj;
    }

    // Get Session storage
    private JSONObject getSessionStorageData() {
        SessionStorage sessionStorage = webStorage.getSessionStorage();
        JSONObject sessionStorageJsonObj = new JSONObject();
        sessionStorage.keySet().stream()
                .forEach(x -> sessionStorageJsonObj.put(x, sessionStorage.getItem(x)));
        return sessionStorageJsonObj;
    }

    // Get Cookies
    private JSONArray getCookiesData() {
        JSONArray cookies = new JSONArray();
        driver.manage().getCookies().stream()
                .forEach(
                        x -> {
                            JSONObject json = new JSONObject();
                            json.put("name", x.getName());
                            json.put("value", x.getValue());
                            json.put("path", x.getPath());
                            json.put("domain", x.getDomain());
                            json.put("expiry", x.getExpiry());
                            json.put("isSecure", x.isSecure());
                            json.put("isHttpOnly", x.isHttpOnly());
                            cookies.put(json);
                        });
        return cookies;
    }

    public void usePreviousLoggedInSession(String fileName) {

        driver.manage().getCookies().clear();
        // Read Json file
        JSONObject jsonObj = null;
        jsonObj = JSONUtils.parseJsonFile(System.getProperty("user.dir") + "/"+fileName+".json");
        // jsonObj = (JSONObject) TestDataHelper.getDataInSuiteScope("user_session");

        JSONObject sessionData = jsonObj.getJSONObject("session_data");

        // Apply Cookies
        applyCookiesToCurrentSession(sessionData);

        // Apply Local storage
        applyLocalStorage(sessionData);

        // Apply Session storage
        applySessionStorage(sessionData);

        // Page Refresh
        driver.navigate().refresh();
    }

    private void applyLocalStorage(JSONObject sessionData) {
        JSONObject localStorageObj = sessionData.getJSONObject("local_storage");
        localStorageObj.keySet().stream()
                .forEach(
                        k -> {
                            webStorage.getLocalStorage().setItem(k, localStorageObj.get(k).toString());
                        });
    }

    private void applySessionStorage(JSONObject sessionData) {
        JSONObject sessionStorageObj = sessionData.getJSONObject("session_storage");
        sessionStorageObj.keySet().stream()
                .forEach(
                        k -> {
                            webStorage.getSessionStorage().setItem(k, sessionStorageObj.get(k).toString());
                        });
    }

    private void applyCookiesToCurrentSession(JSONObject jsonObject) {

        JSONArray cookiesArray = jsonObject.getJSONArray("cookies");
        for (int i = 0; i < cookiesArray.length(); i++) {
            JSONObject cookies = cookiesArray.getJSONObject(i);
            Cookie ck =
                    new Cookie.Builder(cookies.get("name").toString(), cookies.get("value").toString())
                            .path(cookies.get("path").toString())
                            .domain(cookies.get("domain").toString())
                            .expiresOn(
                                    !cookies.has("expiry") ? null : new Date(new Date().getTime() + 3600 * 1000))
                            .isSecure((Boolean) cookies.get("isSecure"))
                            .isHttpOnly((Boolean) cookies.get("isHttpOnly"))
                            .build();
            driver.manage().addCookie(ck);
        }
    }

}
