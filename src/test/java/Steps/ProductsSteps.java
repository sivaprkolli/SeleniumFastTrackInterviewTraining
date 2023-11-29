package Steps;

import AAACucumber.WebDriverFactory;
import AAAWebPages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProductsSteps extends WebDriverFactory {
    public ProductsPage productsPage;


    @Then("User navigated to products page")
    public void user_navigated_to_products_page() {
        productsPage = new ProductsPage(driver);
        productsPage.isProductsTitleDisplayed();
    }

    @And("User logout")
    public void user_logout(){
        productsPage.logout();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
