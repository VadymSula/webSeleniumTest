package tests.more;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class HelpCenterTest extends BaseTest {

    @Test
    @Parameters("inputPhrase")
    public void isExistListOfMessengersAfterAppealToHelpCenterTest(String inputPhrase) {
        boolean actualResult = basePage
                .goToHelpCenterPage()
                .inputPhraseAndSubmit(inputPhrase)
                .scrollToContactUsButtonAndClick()
                .isExistListOfMessengers();

        Assert.assertTrue(actualResult);
    }
}
