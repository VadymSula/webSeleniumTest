package pages.cabinet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CabinetPage extends BasePage {
    @FindBy(xpath = "//a[@class='header__button ng-star-inserted']")
    protected WebElement MY_ORDERS;
    @FindBy(linkText = "/cabinet/personal-information/")
    protected WebElement PERSONAL_INFO;
    @FindBy(xpath = "//*[contains(text(), 'Электронная почта')]/following-sibling::p[1]")
    protected WebElement PERSONAL_EMAIL;

    public CabinetPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CabinetPage goToPersonalInfo() {
        getElement().clickOnElement(PERSONAL_INFO);
        return this;
    }

    public CabinetPage goToMyOrders() {
        getElement().clickOnElement(MY_ORDERS);
        return this;
    }

    public String getPersonalEmailAfterLogin() {
        return getElement().getTextFromElement(PERSONAL_EMAIL).trim();
    }
}
