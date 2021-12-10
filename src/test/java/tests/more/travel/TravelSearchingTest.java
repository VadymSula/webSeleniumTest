package tests.more.travel;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TravelSearchingTest extends BaseTest {

    @Test
    public void travelTest() {
        boolean actualResult = basePage
                .clickOnTravelButton()
                .closeModalOfTravelInfo()
                .chooseDepartureOptions()
                .chooseArrivalOptions()
                .clickOnTravelSearchButton()
                .isCorrectNameArrivalAfterSearch();

        Assert.assertTrue(actualResult);
    }
}
