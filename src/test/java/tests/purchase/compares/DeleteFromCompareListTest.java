package tests.purchase.compares;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class DeleteFromCompareListTest extends BaseTest {

    @Test
    public void addProductToCompareListAndDeleteHisTest() {
        boolean actualResult = basePage
                .clickOnLaptopsAndComputersCategoryButton()
                .clickOnLaptopsButton()
                .chooseFirstItem()
                .clickOnAddToCompareButton()
                .clickOnListOfComparesButton()
                .chooseLaptopsCategoryFromListOfCompares()
                .clickOnMoreActionsButton()
                .clickOnDeleteProductFromCompareListButton()
                .isExistMessageListOfComparesIsEmpty();

        Assert.assertTrue(actualResult);
    }
}
