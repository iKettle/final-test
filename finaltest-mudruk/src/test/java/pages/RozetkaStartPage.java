package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RozetkaStartPage extends BasePage {

    public RozetkaStartPage(WebDriver driver) {
        super(driver);
    }

    public void selectItemFromCatalog(String itemName) {
        WebElement notebooks = getDriver().findElement(By.linkText(itemName));
        notebooks.click();
    }
}
