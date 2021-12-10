package tests.purchase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.purchase.PurchasePage;
import tests.BaseTest;

public class SubscribePremiumTest extends BaseTest {
    PurchasePage purchasePage = new PurchasePage(getWebDriver());

    @Test
    public void subscribePremiumTest() {
        boolean actualResult = purchasePage
                .clickOnMainMenu()
                .clickOnPremiumLink()
                .clickOnChooseYourPremiumButton()
                .isExistSubscribeButtons();

        Assert.assertTrue(actualResult);
    }
}
