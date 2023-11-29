package Steps;

import AAACucumber.WebDriverFactory;
import AAAWebPages.LoginPage;
import AAAWebPages.ProductsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SauceLoginSteps extends WebDriverFactory {
    public LoginPage loginPage;

    @Given("User on landing page")
    public void user_on_landing_page() {
        loginPage = new LoginPage(driver);
        loginPage.isUserNameInputBoxDisplayed();
    }
    @When("User enter valid credentials")
    public void user_enter_valid_credentials() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @When("User enter invalid credentials {string} and {string}")
    //@When("User enter invalid credentials (.*?) and (.*?)")
    public void user_enter_invalid_credentials_and(String username, String password) {
        loginPage.login(username, password);
    }

    @When("User enter invalid username and valid password")
    public void user_enter_invalid_username_and_valid_password(Map<String, String> dataTable) {
        //List<Map<String, String>> userDetails = new ArrayList<>();
        String un = dataTable.get("username");
        String pwd = dataTable.get("password");

        loginPage.login(un, pwd);

    }

}
