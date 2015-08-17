package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by me.kettle on 15.08.2015.
 */
public class ComputersNotebooksPage extends TestBase{
    public static final String CATEGORY_LOCATOR_PATTERN = "//div[@class = 'pab-cell pab-img-150'][descendant::a[contains(text(), 'Ноутбуки')]]//li";
    public List<WebElement> notebooksCategory;

    public List<WebElement> allNotebooksCategory(){

        List<WebElement> notebookCategory = driver.findElements(By.xpath(CATEGORY_LOCATOR_PATTERN));

        System.out.println(notebookCategory);

        return notebookCategory;

    }

    public void selectCategory(String category){

        notebooksCategory = allNotebooksCategory();

        for(WebElement cat : notebooksCategory){
            if (cat.getText().contains(category)){
                driver.findElement(By.xpath("//div[@class = 'pab-cell pab-img-150'][descendant::a[contains(text(), 'Ноутбуки')]]//li/a/span[contains(text(), 'Все ноутбуки')]/..")).click();
            }
        }

    }
}
