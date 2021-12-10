package tests.purchase.filters;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ReadyForDispatchTest extends BaseTest {

    @Test
    public void isAllProductsReadyForDispatchTest() {
        boolean actualResult = basePage
                .clickOnLaptopsAndComputersCategoryButton()
                .clickOnLaptopsButton()
                .clickOnReadyForDispatchButton()
                .isAllItemsReadyForDispatch();

        Assert.assertTrue(actualResult);
    }
}
