package tests.purchase;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ChoosingCategoryTest extends BaseTest {

    @Test
    public void choosingCategoryFromCatalogTest() {
        boolean actualResult = basePage
                .goToCatalogPage()
                .clickOnAlcoholAndProductsCategory()
                .isFoundAlcoholCategory();

        Assert.assertTrue(actualResult);
    }
}
