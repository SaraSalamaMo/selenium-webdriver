package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait ;
    private By emailLocator = By.id("user-name");
    private By passwordLocator = By.xpath("//input[@type='password']");
    private By loginButton = By.id("login-button");
    private By errorContainer = By.cssSelector("[data-test = 'error']");
    private By errorButton = By.cssSelector(".error-button");  // xpath = //button[@class='error-button']

    public LoginPage(WebDriver driver){

        this.driver = driver;
        wait = new WebDriverWait(this.driver , 10);
    }

    public void setEmail(String email){

        driver.findElement(emailLocator).sendKeys(email);

    }

    public void setPassword(String password){

        driver.findElement(passwordLocator).sendKeys(password);
    }

    public ProductsPage login(){

        driver.findElement(loginButton).click();
        return new ProductsPage(driver) ;
    }

    private void clearUserName(){

        WebElement email = driver.findElement(emailLocator);
        email.sendKeys(Keys.COMMAND + "a");
        email.sendKeys(Keys.DELETE);
    }

    private void clearPassword(){

        WebElement password = driver.findElement(passwordLocator);
        password.sendKeys(Keys.COMMAND + "a");
        password.sendKeys(Keys.DELETE);
    }
    public void clearUserNameAndPassword(){

        clearUserName();
        clearPassword();
    }

    public void closeErrorMessage(){

        driver.findElement(errorButton).click();
    }


    public void assertFailedLogin(){

        String actualResult =  driver.findElement(errorContainer).getText();
        String expectedResult = "Epic sadface: Username and password do not match any user in this service";

        Assert.assertEquals(actualResult, expectedResult);
    }


}
