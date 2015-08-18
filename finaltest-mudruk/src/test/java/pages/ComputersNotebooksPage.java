package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ComputersNotebooksPage extends BasePage {
    public static final String CATEGORY_LOCATOR = "//div[@class = 'pab-cell pab-img-150'][descendant::a[contains(text(), '%s')]]//li//a";
    public static final String CATEGORY_LINK_PATTERN = "//div[@class = 'pab-cell pab-img-150'][descendant::a[contains(text(), '%s')]]//li" +
            "//*[contains(text(), '%s')]";

    public ComputersNotebooksPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSubcategoryList(String categoryName) {
        String categoryLocator = String.format(CATEGORY_LOCATOR, categoryName);
        return getDriver().findElements(By.xpath(categoryLocator));
    }

    public void selectSubcategory(String categoryName, String subcategoryName) {
        String subcategoryLocator = String.format(CATEGORY_LINK_PATTERN, categoryName, subcategoryName);
        getDriver().findElement(By.xpath(subcategoryLocator)).click();
    }
}
