package AAAWebPages;

import AAAActions.SeleniumActions;
import AAAWaits.SeleniumWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    private WebDriver driver;

    public SeleniumActions seleniumActions;
    public SeleniumWaits seleniumWaits;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
        seleniumWaits = new SeleniumWaits(driver);
    }

    @FindBy(css = "span.title")
    private WebElement productsTitle;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement hamburgerMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public void logout(){
        hamburgerMenu.click();
        logoutLink.click();
    }
    public boolean isProductsTitleDisplayed(){
        return productsTitle.isDisplayed();
    }
}
