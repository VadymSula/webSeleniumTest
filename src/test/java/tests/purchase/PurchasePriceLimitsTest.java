package tests.purchase;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class PurchasePriceLimitsTest extends BaseTest {

    @Test
    @Parameters({"minPrice", "maxPrice"})
    public void purchaseLimitsBetweenPricesTest(String minPrice, String maxPrice) {
        boolean actualResult = basePage
                .clickOnLaptopsAndComputersCategoryButton()
                .clickOnLaptopsButton()
                .scrollToPriceBlockAndFillInFieldsPrices(minPrice, maxPrice)
                .isSuitInputPriceWithPriceAfterSort(minPrice, maxPrice);

        Assert.assertTrue(actualResult);
    }
}
