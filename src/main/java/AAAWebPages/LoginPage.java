package AAAWebPages;

import AAAActions.SeleniumActions;
import AAAWaits.SeleniumWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public SeleniumActions seleniumActions;
    public SeleniumWaits seleniumWaits;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
        seleniumWaits = new SeleniumWaits(driver);
    }

    @FindBy(name = "user-name")
    private WebElement userNameInputBox;

    @FindBy(id = "password")
    private WebElement passwordInputBox;

    @FindBy(css = ".submit-button.btn_action")
    private WebElement loginButton;

    By userNameField = By.name("user-name");
    By passwordField = By.id("password");
    By submitButton = By.cssSelector(".submit-button.btn_action");

    public void login(String userName, String password) {
        userNameInputBox.sendKeys(userName);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }

    public boolean isUserNameInputBoxDisplayed(){
        return userNameInputBox.isDisplayed();
    }

    public void login() {
        driver.findElement(userNameField).sendKeys("standard_user");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(submitButton).click();
    }

    public void login(String username, String password, int i){
        seleniumWaits.waitForElementToBeVisible(userNameInputBox);
        seleniumActions.enterValue(userNameField, username);
        seleniumActions.enterValue(passwordInputBox, password);
        seleniumActions.clickOnElement(submitButton);
    }

}
