package ui_test;

import core.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CompareNotebooksPage;
import pages.ComputersNotebooksPage;
import pages.NotebooksPage;
import pages.RozetkaStartPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CompareNotebooksTest extends TestBase {

    public final static String SITE_URL = "http://rozetka.com.ua/";
    public final static String NOTEBOOK_1 = "Apple MacBook Pro Retina 13\" (Z0QP000X6)";
    public final static String NOTEBOOK_2 = "Apple MacBook Pro Retina 15\" (MGXA2UA/A)";

    @Test
    public void compareNotebooksTest() {
        RozetkaStartPage rozetkaStartPage = new RozetkaStartPage(getDriver());
        rozetkaStartPage.open(SITE_URL);
        assertTrue(getDriver().getCurrentUrl().equals(SITE_URL));
        rozetkaStartPage.selectItemFromCatalog("Ноутбуки, планшеты и компьютеры");

        ComputersNotebooksPage computersNotebooksPage = new ComputersNotebooksPage(getDriver());
        List<WebElement> categories = computersNotebooksPage.getSubcategoryList("Ноутбуки");
        assertTrue(categories.size() == 6);
        computersNotebooksPage.selectSubcategory("Ноутбуки", "Все ноутбук");

        NotebooksPage notebooksPage = new NotebooksPage(getDriver());
        List<WebElement> listOfManufactures = notebooksPage.findAllFilterItems("Производители");
        assertEquals(listOfManufactures.size(), 9);
        notebooksPage.filterItems("Производители", "Apple");

        assertTrue(getDriver().getTitle().contains("Apple"));

        notebooksPage.sortNotebooks("от дорогих к дешевым");

        assertTrue(notebooksPage.itemIsDisplayed(NOTEBOOK_1));
        notebooksPage.addToCompareList(NOTEBOOK_1);
        assertTrue(notebooksPage.checkItemIsPresentInCompareList(NOTEBOOK_1));
        assertTrue(notebooksPage.itemIsDisplayed(NOTEBOOK_2));
        notebooksPage.addToCompareList(NOTEBOOK_2);
        assertTrue(notebooksPage.checkItemIsPresentInCompareList(NOTEBOOK_1));
        assertTrue(notebooksPage.checkItemIsPresentInCompareList(NOTEBOOK_2));

        CompareNotebooksPage compareNotebooksPage = notebooksPage.openCompareList();

        assertTrue(compareNotebooksPage.checkIsPresentInComparePage(NOTEBOOK_1));
        assertTrue(compareNotebooksPage.checkIsPresentInComparePage(NOTEBOOK_2));
    }

}
