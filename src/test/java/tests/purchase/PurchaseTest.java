package tests.purchase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.purchase.BasketPage;
import pages.purchase.PurchasePage;
import tests.BaseTest;

public class PurchaseTest extends BaseTest {
    PurchasePage purchasePage = new PurchasePage(getWebDriver());
    BasketPage basketPage = new BasketPage(getWebDriver());
    private static final String SEARCH_ITEM_NAME = "DMF";

    @Test
    public void buyFirstItem() {
        boolean actualResult = purchasePage
                .searchItem(SEARCH_ITEM_NAME)
                .clickOnSearchButton()
                .chooseFirstItem()
                .buyItem()
                .isExistElementInBasket();
        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    public void isElementNameInBasketBeforeBuying() {
        boolean actualResult = basketPage.isExistNameOfElementBasket(SEARCH_ITEM_NAME);

        Assert.assertTrue((actualResult));
    }

    @Test(priority = 2)
    public void isEmptyBasket() {
        boolean actualResult = basketPage
                .clickOnMoreActionsButton()
                .deleteProductFromBasket()
                .isExistInfoMessageWithText("Корзина пуста");

        Assert.assertTrue(actualResult);
    }


}
