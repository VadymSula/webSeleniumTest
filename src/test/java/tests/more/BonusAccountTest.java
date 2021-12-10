package tests.more;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BonusAccountTest extends BaseTest {

    @Test
    public void isExistLoginPageAfterBonusAccountVisitTest() {
        boolean actualResult = basePage
                .scrollAndClickOnBonusAccountButton()
                .clickOnActivateAccountButton()
                .isExistHeadingLogin();

        Assert.assertTrue(actualResult);
    }
}
