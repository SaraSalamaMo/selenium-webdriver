package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By addToCart = By.id("add-to-cart-sauce-labs-backpack");

    public ProductsPage(WebDriver driver){

        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public String getAddToCart(){

       return wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart)).getText();
    }

    public void assertProductsPageWasOpened(){

        String actualResult = getAddToCart();
        String expectedResult = "Add to cart";
        Assert.assertEquals(actualResult, expectedResult);
    }

}
