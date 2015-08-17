package ui_test;

import core.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AllNotebooksPage;
import pages.AppleNotebooks;
import pages.ComputersNotebooksPage;
import pages.RozetkaStartPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by me.kettle on 15.08.2015.
 */
public class CompareNotebooksTest extends TestBase{

    public String webSite = "http://rozetka.com.ua/";
    public String manufacture = "Apple";
    public String notebook1 = "Apple MacBook Pro Retina 13\" (Z0QP000X6)";
    public String notebook2 = "Apple MacBook Pro Retina 15\" (MGXA2UA/A)";

    @Test
    public void compareNotebooksTest(){
        RozetkaStartPage rozetkaStartPage = new RozetkaStartPage();

        rozetkaStartPage.open(webSite);
        assertTrue(driver.getCurrentUrl().equals(webSite));

        rozetkaStartPage.selectNotebookItem();

        ComputersNotebooksPage computersNotebooksPage = new ComputersNotebooksPage();

        List<WebElement> categories = computersNotebooksPage.allNotebooksCategory();

        assertTrue(categories.size()== 6);
        computersNotebooksPage.selectCategory("Все ноутбуки");

        AllNotebooksPage allNotebooksPage = new AllNotebooksPage();
        List<WebElement> listOfManufactures = allNotebooksPage.findAllManufactures();

        assertEquals(listOfManufactures.size(), 9);

        allNotebooksPage.selectManufacture(manufacture);

        assertTrue(driver.getTitle().contains(manufacture));

        AppleNotebooks appleNotebooks = new AppleNotebooks();

        appleNotebooks.sortNotebooks("от дорогих к дешевым");


        

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

}
