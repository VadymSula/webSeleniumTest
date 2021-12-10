package pages;

import elements.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.login.LoginPage;
import pages.more.BonusAccountPage;
import pages.more.HelpCenterPage;
import pages.more.TradeInPage;
import pages.more.TravelPage;
import pages.purchase.CatalogPage;
import pages.purchase.MenuPage;
import pages.purchase.PurchasePage;

public class BasePage {
    protected WebDriver webDriver;
    private final Element element;

    @FindBy(name = "search")
    protected WebElement SEARCH_FIELD;
    @FindBy(xpath = "//*[contains(text(), 'Найти')]")
    protected WebElement SEARCH_BUTTON;
    @FindBy(xpath = "//button[@class='header__button ng-star-inserted']")
    protected WebElement INPUT_BUTTON;
    @FindBy(id = "fat-menu")
    protected WebElement CATALOG_BUTTON;
    @FindBy(xpath = "//a[contains(text(),'Справочный центр')]")
    protected WebElement HELP_CENTER;
    @FindBy(css = "button[aria-label='Открыть меню']")
    protected WebElement MAIN_MENU;
    @FindBy(xpath = "//a[@class = 'menu-categories__link' and contains(text(), 'Ноутбуки')]")
    protected WebElement LAPTOPS_AND_COMPUTERS_CATEGORY;
    @FindBy(xpath = "//a[text() = ' Бонусный счет ']")
    protected WebElement BONUS_ACCOUNT;
    @FindBy(xpath = "//a[text() = ' Rozetka Обмен ']")
    protected WebElement TRADE_IN_BUTTON;
    @FindBy(xpath = "//a[text() = ' Rozetka Travel ']")
    protected WebElement TRAVEL_BUTTON;

    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        element = new Element(webDriver);
        this.webDriver = webDriver;
    }

    public Element getElement() {
        return element;
    }

    public BasePage searchItem(String keyWord) {
        SEARCH_FIELD.sendKeys(keyWord);
        return new PurchasePage(webDriver);
    }

    public PurchasePage clickOnSearchButton() {
        getElement().clickOnElement(SEARCH_BUTTON);
        return new PurchasePage(webDriver);
    }

    public LoginPage goToLoginPage() {
        getElement().clickOnElement(INPUT_BUTTON);
        return new LoginPage(webDriver);
    }

    public CatalogPage goToCatalogPage() {
        getElement().clickOnElement(CATALOG_BUTTON);
        return new CatalogPage(webDriver);
    }

    public HelpCenterPage goToHelpCenterPage() {
        getElement().scrollToElement(HELP_CENTER);
        getElement().clickOnElement(HELP_CENTER);
        return new HelpCenterPage(webDriver);
    }

    public MenuPage clickOnMainMenu() {
        getElement().clickOnElement(MAIN_MENU);
        return new MenuPage(webDriver);
    }

    public PurchasePage clickOnLaptopsAndComputersCategoryButton() {
        getElement()
                .scrollToElement(LAPTOPS_AND_COMPUTERS_CATEGORY)
                .clickOnElement(LAPTOPS_AND_COMPUTERS_CATEGORY);
        return new PurchasePage(webDriver);
    }

    public BonusAccountPage scrollAndClickOnBonusAccountButton() {
        getElement()
                .scrollToElement(BONUS_ACCOUNT)
                .clickOnElement(BONUS_ACCOUNT);
        return new BonusAccountPage(webDriver);
    }

    public TradeInPage clickOnTradeInButton() {
        getElement().clickOnElement(TRADE_IN_BUTTON);
        return new TradeInPage(webDriver);
    }

    public TravelPage clickOnTravelButton() {
        getElement().clickOnElement(TRAVEL_BUTTON);
        return new TravelPage(webDriver);
    }
}
