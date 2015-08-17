package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by me.kettle on 15.08.2015.
 */
public class RozetkaStartPage extends TestBase {
    public WebElement notebooks;

    public void open(String URL){
        driver.get(URL);
    }

    public void selectNotebookItem(){
        notebooks = driver.findElement(By.linkText("Ноутбуки, планшеты и компьютеры"));
        notebooks.click();
    }
}
