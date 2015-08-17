package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by me.kettle on 17.08.2015.
 */
public class AllNotebooksPage extends TestBase{

    public List<WebElement> findAllManufactures(){

        List<WebElement> listOfManufacture = driver.findElements(By.xpath("//li[@class = 'm-cat-l-i'][descendant::*[contains(text(),'Производители')]]//ul//li//a"));

        return listOfManufacture;
    }

    public void selectManufacture(String manufacture){

        List<WebElement> listOfManufactures = findAllManufactures();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        for(WebElement man : listOfManufactures){
            if (man.getText().contains(manufacture)){
                man.click();
                break;
            }
        }
    }
}
