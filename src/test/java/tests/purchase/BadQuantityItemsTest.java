package tests.purchase;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BadQuantityItemsTest extends BaseTest {

    @Test
    public void zeroQuantityItemsInBasketTest() {
        boolean actualResult = basePage
                .clickOnLaptopsAndComputersCategoryButton()
                .clickOnLaptopsButton()
                .chooseFirstItem()
                .buyItem()
                .fillInZeroInFieldForItemsQuantity()
                .isExistMessageAboutInvalidCountOfItems();

        Assert.assertTrue(actualResult);
    }
}
