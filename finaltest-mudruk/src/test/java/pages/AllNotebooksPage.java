package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by me.kettle on 17.08.2015.
 */
public class AllNotebooksPage extends TestBase{
    List<WebElement> listOfManufactures;

    public List<WebElement> findAllManufactures(){

        listOfManufactures = driver.findElements(By.xpath("//li[@class = 'm-cat-l-i'][descendant::*[contains(text(),'Производители')]]//ul//li"));

        return listOfManufactures;
    }

    public void selectManufacture(String manufacture){
        for(WebElement man : listOfManufactures){
            if (man.getText().contains(manufacture)){
                man.click();
            }
        }
    }
}
