package tests;

import org.testng.annotations.Test;
import pages.ProductsPage;

public class loginTest extends baseTest{

    @Test
    public void successfulLoginTest(){

        String email = "standard_user";
        String password = "secret_sauce";

        loginPage.clearUserNameAndPassword();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        ProductsPage productsPage = loginPage.login();

        productsPage.assertProductsPageWasOpened();

    }

    @Test
    public void failedLoginTest(){

        String email = "fail";
        String password = "fail";
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.login();

        loginPage.assertFailedLogin();

        loginPage.closeErrorMessage();

    }

}
