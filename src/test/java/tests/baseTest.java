package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

public class baseTest {

    private WebDriver driver;
    public LoginPage loginPage;


    @BeforeClass
    public void setUp(){

        String Url = "https://www.saucedemo.com/";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(Url);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown(){

        driver.close();
    }

}
