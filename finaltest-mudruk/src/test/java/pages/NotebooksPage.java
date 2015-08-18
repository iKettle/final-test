package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NotebooksPage extends BasePage {

    public static final String SORT_BY_PATTERN = "//*[@id='sort_view']//a[contains(text(),'%s')]";
    public static final String ITEM_NAME_PATTERN = "//*[@id='block_with_goods']//div/a[contains(text(),'%s')]";
    public static final String COMPARE_ITEM_NAME_PATTERN = "//ul[@class='list-compare-l']/li/a[contains(text(),'%s')]";
    public static final String FILTER_ITEMS_PATTERN = "//li[@class = 'm-cat-l-i'][descendant::*[contains(text(),'%s')]]//ul//li//a";
    public static final String FILTER_ITEM_PATTERN = "//li[@class = 'm-cat-l-i'][descendant::*[contains(text(),'%s')]]//ul//li//a" +
            "[contains(text(), '%s')]";

    @FindBy(xpath = "//*[@id='sort_view']//a")
    private WebElement sortDropdownList;

    @FindBy(xpath = "//*[@class='logo']")
    private WebElement logo;

    public NotebooksPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> findAllFilterItems(String filterName) {
        String filterItemsLocator = String.format(FILTER_ITEMS_PATTERN, filterName);
        return getDriver().findElements(By.xpath(filterItemsLocator));
    }

    public void filterItems(String filterName, String filterItem) {
        String filterItemLocator = String.format(FILTER_ITEM_PATTERN, filterName, filterItem);
        getDriver().findElement(By.xpath(filterItemLocator)).click();
    }

    public void sortNotebooks(String sortBy) {
        sortDropdownList.click();
        getDriver().findElement(By.xpath(String.format(SORT_BY_PATTERN, sortBy))).click();
    }

    public boolean itemIsDisplayed(String item) {
        return getDriver().findElement(By.xpath(String.format(ITEM_NAME_PATTERN, item))).isDisplayed();
    }

    public void addToCompareList(String item) {
        String path = String.format(ITEM_NAME_PATTERN, item).replace("\\", "");
        //added dark magic because of *** rozetka developers
        clickElementByXpath(getDriver(), path + "/../following-sibling::div//*[@class = 'g-tools-i g-tools-delimiter']//label");
        moveToElement(getDriver(), logo);
    }

    public boolean checkItemIsPresentInCompareList(String item) {
        String compareItemLocator = String.format(COMPARE_ITEM_NAME_PATTERN, item).replace("\\", "");
        return waitUntilVisibilityOfElementWithXpath(compareItemLocator).isDisplayed();
    }

    public CompareNotebooksPage openCompareList() {
        getDriver().findElement(By.xpath("//*[@id='catalog-comparison']//*[@class = 'list-compare-more']/a")).click();
        return new CompareNotebooksPage(getDriver());
    }
}
