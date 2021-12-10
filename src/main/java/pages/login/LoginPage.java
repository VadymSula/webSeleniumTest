package pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.cabinet.CabinetPage;

public class LoginPage extends BasePage {
    @FindBy(className = "auth-page__heading")
    protected WebElement HEADING_LOGIN;
    @FindBy(id = "auth_email")
    protected WebElement EMAIL_INPUT;
    @FindBy(id = "auth_pass")
    protected WebElement PASSWORD_INPUT;
    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    protected WebElement SIGN_IN_BUTTON;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage fillCredentials(String email, String password) {
        getElement()
                .searchFieldAndSendKey(EMAIL_INPUT, email)
                .searchFieldAndSendKey(PASSWORD_INPUT, password);
        return this;
    }

    public CabinetPage clickOnSignInButton() {
        getElement().clickOnElement(SIGN_IN_BUTTON);
        return new CabinetPage(webDriver);
    }

    public boolean isExistHeadingLogin() {
        return getElement().isElementExist(HEADING_LOGIN);
    }
}
