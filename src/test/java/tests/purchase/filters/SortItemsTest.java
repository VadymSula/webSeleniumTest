package tests.purchase.filters;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SortItemsTest extends BaseTest {

    @Test
    public void sortItemsFromCheapToExpensiveTest() {
        boolean actualResult = basePage
                .clickOnLaptopsAndComputersCategoryButton()
                .clickOnLaptopsButton()
                .clickOnSortSelectAndChooseFromCheapToExpensiveSelect()
                .isSortedProductsFromCheapToExpensive();

        Assert.assertTrue(actualResult);
    }
}
