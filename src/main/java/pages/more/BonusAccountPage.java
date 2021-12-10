package pages.more;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.login.LoginPage;

public class BonusAccountPage extends BasePage {
    @FindBy(xpath = "//a[text() = 'Активировать счет']")
    protected WebElement ACTIVATE_ACCOUNT_BUTTON;

    public BonusAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage clickOnActivateAccountButton() {
        getElement()
                .scrollToElement(ACTIVATE_ACCOUNT_BUTTON)
                .clickOnElement(ACTIVATE_ACCOUNT_BUTTON);
        return new LoginPage(webDriver);
    }
}
