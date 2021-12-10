package tests.more;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.more.TradeInPage;
import tests.BaseTest;

public class TradeInTest extends BaseTest {

    @Test
    public void isExistHowToUseTitleOnTradeInTest() {
        boolean actualResult = basePage
                .clickOnTradeInButton()
                .isExistHowToUseTitle();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    public void isExistAllGadgetsOnTradeInTest() {
        boolean actualResult = new TradeInPage(getWebDriver())
                .scrollToConditionsBlock()
                .isExistGadgetsForTradeIn();

        Assert.assertTrue(actualResult);
    }
}
