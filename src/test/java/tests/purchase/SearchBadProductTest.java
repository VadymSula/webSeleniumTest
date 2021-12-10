package tests.purchase;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SearchBadProductTest extends BaseTest {

    @Test
    @Parameters("searchPhrase")
    public void searchBadProductAndGetMessageAboutNotFoundProductTest(String searchPhrase) {
        boolean actualResult = basePage
                .searchItem(searchPhrase)
                .clickOnSearchButton()
                .isExistMessageAboutProductNotFound();

        Assert.assertTrue(actualResult);
    }
}
