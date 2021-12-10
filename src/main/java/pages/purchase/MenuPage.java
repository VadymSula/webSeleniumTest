package pages.purchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.more.VacanciesPage;

public class MenuPage extends BasePage {
    @FindBy(xpath = "//span[text()=' PREMIUM ']/ancestor::a[1]")
    protected WebElement PREMIUM_LINK;
    @FindBy(xpath = "//div[@class = 'premium-cta__body']/following-sibling::button")
    protected WebElement CHOOSE_YOUR_PREMIUM_BUTTON;
    @FindBy(xpath = "//button[contains(text(), 'Оформить подписку')]")
    protected WebElement SUBSCRIBE_BUTTON;
    @FindBy(xpath = "//a[@class = 'ng-tns-c19-2' and text() = ' Вакансии ']")
    protected WebElement VACANCIES_BUTTON;

    public MenuPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MenuPage clickOnPremiumLink() {
        getElement().clickOnElementWithWait(PREMIUM_LINK, 2L);
        return this;
    }

    public MenuPage clickOnChooseYourPremiumButton() {
        getElement().clickOnElement(CHOOSE_YOUR_PREMIUM_BUTTON);
        return this;
    }

    public boolean isExistSubscribeButtons() {
        return getElement().isElementExist(SUBSCRIBE_BUTTON);
    }

    public VacanciesPage clickOnVacanciesButton() {
        getElement().clickOnElement(VACANCIES_BUTTON);
        return new VacanciesPage(webDriver);
    }
}
