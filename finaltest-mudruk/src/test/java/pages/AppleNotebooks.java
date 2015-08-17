package pages;

import core.TestBase;
import org.openqa.selenium.By;

/**
 * Created by me.kettle on 17.08.2015.
 */
public class AppleNotebooks extends TestBase{

    public void sortNotebooks(String sortBy){

        //driver.findElement(By.id("sort-view")).click();

        driver.findElement(By.xpath("//*[@id='sort_view']//a")).click();

        String path = String.format("//a[contains(text(),'%s')]", sortBy);
        driver.findElement(By.xpath(path)).click();

    }
}
