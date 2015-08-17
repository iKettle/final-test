package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by me.kettle on 15.08.2015.
 */
public class TestBase {
    protected static WebDriver driver;
    protected WebDriverWait webDriverWait;


    @BeforeSuite
    public void setUp() throws IOException{
        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}
