package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(String URL) {
        driver.get(URL);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void clickElementByXpath(WebDriver driver, String xpath) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
        action.moveToElement(driver.findElement(By.xpath(xpath))).click().build().perform();
    }

    public void moveToElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public WebElement waitUntilVisibilityOfElementWithXpath(String xpathLocator) {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
    }
}
