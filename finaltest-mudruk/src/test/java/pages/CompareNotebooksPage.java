package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class CompareNotebooksPage extends BasePage {
    public final static String COMPARED_ITEM_NAME_PATTERN = "//*[@class='comparison-thead-row-first']//" +
            "*[@class='g-title']/a[contains(text(), '%s')]";

    public CompareNotebooksPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIsPresentInComparePage(String itemName) {
        String comparedItemLocator = String.format(COMPARED_ITEM_NAME_PATTERN, itemName).replace("\\", "");
        return waitUntilVisibilityOfElementWithXpath(comparedItemLocator).isDisplayed();
    }
}
