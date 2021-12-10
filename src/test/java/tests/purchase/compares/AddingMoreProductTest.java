package tests.purchase.compares;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.purchase.PurchasePage;
import pages.purchase.compares.ComparesPage;
import tests.BaseTest;

public class AddingMoreProductTest extends BaseTest {

    @Test
    public void addMoreProductToListOfComparesTest() {
        basePage
                .clickOnLaptopsAndComputersCategoryButton()
                .clickOnLaptopsButton()
                .chooseFirstItem();
                addToCompareClickOnListAndChooseLaptopsStep()
                .clickOnAddMoreModelButton()
                .chooseSecondItem();
        boolean actualResult = addToCompareClickOnListAndChooseLaptopsStep()
                .isExistTwoProductsInTheCompareList();

        Assert.assertTrue(actualResult);
    }

    private ComparesPage addToCompareClickOnListAndChooseLaptopsStep() {
        return new PurchasePage(getWebDriver())
                .clickOnAddToCompareButton()
                .clickOnListOfComparesButton()
                .chooseLaptopsCategoryFromListOfCompares();
    }
}
