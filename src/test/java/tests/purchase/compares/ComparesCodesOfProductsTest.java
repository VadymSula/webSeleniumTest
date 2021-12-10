package tests.purchase.compares;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.purchase.PurchasePage;
import tests.BaseTest;

public class ComparesCodesOfProductsTest extends BaseTest {

    @Test
    public void compareCodeBeforeAddingToCompareListAndAfterHisTest() {
        String codeBeforeAddingToCompareList = basePage
                .clickOnLaptopsAndComputersCategoryButton()
                .clickOnLaptopsButton()
                .chooseFirstItem()
                .clickOnAddToCompareButton()
                .getProductCode();

        String codeAfterAddingToCompareList = new PurchasePage(getWebDriver())
                .clickOnListOfComparesButton()
                .chooseLaptopsCategoryFromListOfCompares()
                .clickOnFirstProductFromComparisonList()
                .getProductCode();

        Assert.assertEquals(codeAfterAddingToCompareList, codeBeforeAddingToCompareList);
    }
}
