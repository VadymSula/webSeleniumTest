package tests.purchase.filters;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class UnavailableItemsTest extends BaseTest {

    @Test
    public void isAllProductsUnavailableTest() {
        boolean actualResult = basePage
                .clickOnLaptopsAndComputersCategoryButton()
                .clickOnLaptopsButton()
                .scrollAndClickOnUnavailableProductsButton()
                .isAllItemsUnavailable();

        Assert.assertTrue(actualResult);
    }
}
