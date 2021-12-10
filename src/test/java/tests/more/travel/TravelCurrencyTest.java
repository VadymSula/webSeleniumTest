package tests.more.travel;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TravelCurrencyTest extends BaseTest {

    @Test
    public void currencyInTravelTest() {
        boolean actualResult = basePage
                .clickOnTravelButton()
                .closeModalOfTravelInfo()
                .chooseOtherCurrencyType()
                .isAllTravelHavePriceInOtherCurrencyType();

        Assert.assertTrue(actualResult);
    }
}
