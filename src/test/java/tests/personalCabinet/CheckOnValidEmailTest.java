package tests.personalCabinet;

import config.ConfigProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.login.LoginPage;
import tests.BaseTest;

public class CheckOnValidEmailTest extends BaseTest {
    LoginPage loginPage = new LoginPage(getWebDriver());

    @Test
    public void isEqualsEmailInputtedBeforeAndAfterLogin() {
        String emailBeforeLogin = ConfigProperties.getProperty("password");

        String actualResult = loginPage
                .goToLoginPage()
                .fillCredentials(ConfigProperties.getProperty("email"),
                        ConfigProperties.getProperty("password"))
                .clickOnSignInButton()
                .goToMyOrders()
                .goToPersonalInfo()
                .getPersonalEmailAfterLogin();

        Assert.assertEquals(emailBeforeLogin, actualResult);
    }
}
