package tests.purchase.compares;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.purchase.compares.ComparesPage;
import tests.BaseTest;

public class ComparesTest extends BaseTest {

    @Test
    public void isExistComparisonHeadingAfterProductAddingToListTest() {
        boolean actualResult = basePage
                .clickOnLaptopsAndComputersCategoryButton()
                .clickOnLaptopsButton()
                .chooseFirstItem()
                .clickOnAddToCompareButton()
                .clickOnListOfComparesButton()
                .chooseLaptopsCategoryFromListOfCompares()
                .isExistComparisonHeading();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    public void isExistMessageAboutNotEnoughProductsForCompareTest() {
        ComparesPage comparesPage = new ComparesPage(getWebDriver());
        boolean actualResult = comparesPage.isExistProductsNotEnoughForCompareMessage();

        Assert.assertTrue(actualResult);
    }
}
