package pages.more;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class TravelPage extends BasePage {
    private static String typeOfCurrency;
    @FindBy(className = "j-modal__close")
    protected WebElement CLOSE_MODAL_BUTTON;
    @FindBy(className = "auth-modal__info")
    protected WebElement TRAVEL_MODAL_INFO;
    @FindBy(css = "li[data-qaid = 'departureDD'] > div")
    protected WebElement DEPARTURE_SELECT;
    @FindBy(id = "b478e17d-1b77-4131-a06f-eb0532465677")
    protected WebElement DEPARTURE_FROM_KHARKOV;
    @FindBy(css = "li[data-qaid = 'arrivalDD'] > div > div")
    protected WebElement ARRIVAL_SELECT;
    @FindBy(id = "0afaf1c3-7069-415b-a44e-bb4f62f82bc5")
    protected WebElement ARRIVAL_SECOND_VARIANT;
    @FindBy(css = "input[type = 'submit']")
    protected WebElement SEARCH_TRAVEL_BUTTON;
    @FindBy(xpath = "//h1[@class = 's-result__title' and contains(text(), 'Мальдивы')]")
    protected WebElement SEARCH_RESULT_TITLE;
    @FindBy(css = "div[class = 'select-box header-dropdown']")
    protected WebElement CURRENCY_SELECT;
    @FindBy(css = "div[class = 'select-dropdown__list'] > div[id = '0']")
    protected WebElement FIRST_CURRENCY_VARIANT;
    @FindBy(tagName = "strong")
    protected List<WebElement> PRICES_OF_TRAVELS;

    public TravelPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TravelPage closeModalOfTravelInfo() {
        getElement().isVisibleElement(TRAVEL_MODAL_INFO);
        getElement().clickOnElement(CLOSE_MODAL_BUTTON);
        return this;
    }

    public TravelPage chooseDepartureOptions() {
        getElement().clickOnElement(DEPARTURE_SELECT);
        getElement().clickOnElement(DEPARTURE_FROM_KHARKOV);

        return this;
    }

    public TravelPage chooseArrivalOptions() {
        getElement().clickOnElement(ARRIVAL_SELECT);
        getElement().clickOnElement(ARRIVAL_SECOND_VARIANT);
        return this;
    }

    public TravelPage clickOnTravelSearchButton() {
        getElement().clickOnElement(SEARCH_TRAVEL_BUTTON);
        return this;
    }

    public boolean isCorrectNameArrivalAfterSearch() {
        return getElement().isVisibleElement(SEARCH_RESULT_TITLE);
    }

    public TravelPage chooseOtherCurrencyType() {
        getElement().clickOnElement(CURRENCY_SELECT);
        typeOfCurrency = String.valueOf(getElement().getTextFromElement(FIRST_CURRENCY_VARIANT).charAt(0));
        getElement().clickOnElement(FIRST_CURRENCY_VARIANT);
        return this;
    }

    public boolean isAllTravelHavePriceInOtherCurrencyType() {
        return PRICES_OF_TRAVELS
                .stream()
                .anyMatch(webElement -> getElement().getTextFromElement(webElement).contains(typeOfCurrency));
    }
}
