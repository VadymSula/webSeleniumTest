package pages.purchase;

import com.google.common.collect.Ordering;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.purchase.compares.ComparesPage;

import java.util.List;
import java.util.stream.Collectors;

public class PurchasePage extends BasePage {
    @FindBy(xpath = "//*[@class='catalog-grid ng-star-inserted']/li")
    protected List<WebElement> ITEMS;
    @FindBy(xpath = "//*[contains(text(), 'Купить')]")
    protected WebElement BUY_BUTTON;
    @FindBy(css = "a[title='Ноутбуки']")
    protected WebElement LAPTOPS_BUTTON;
    @FindBy(css = "button[type = 'submit']")
    protected WebElement PRICE_OK_BUTTON;
    @FindBy(css = "input[formcontrolname = 'min']")
    protected WebElement PRICE_MINIMUM;
    @FindBy(css = "input[formcontrolname = 'max']")
    protected WebElement PRICE_MAXIMUM;
    @FindBy(css = "span[class='goods-tile__price-value']")
    protected List<WebElement> PRICE_VALUE_OF_ITEMS;
    @FindBy(xpath = "//span[contains(text(), 'По заданным ')]")
    protected WebElement MESSAGE_ABOUT_NOT_FOUND;
    @FindBy(xpath = "//button[@class = 'compare-button ng-star-inserted']")
    protected WebElement ADD_TO_COMPARE_BUTTON;
    @FindBy(xpath = "//span[@class = 'product__code-accent']/..")
    protected WebElement PRODUCT_CODE;
    @FindBy(css = "button[aria-label = 'Списки сравнения']")
    protected WebElement LIST_OF_COMPARES;
    @FindBy(xpath = "//a[@class = 'comparison-modal__link' and contains(text(), 'Ноутбуки')]")
    protected WebElement LAPTOPS_CATEGORY_FROM_COMPARES_LIST;
    @FindBy(xpath = "//input[@id = 'Готов к отправке']/..")
    protected WebElement READY_FOR_DISPATCH_BUTTON;
    @FindBy(xpath = "//div[text() = ' Готов к отправке ']/ancestor::li[1]")
    protected List<WebElement> ITEMS_READY_FOR_DISPATCH;
    @FindBy(xpath = "//input[@id = 'Нет в наличии']/..")
    protected WebElement UNAVAILABLE_BUTTON;
    @FindBy(xpath = "//div[text() = ' Нет в наличии ']/ancestor::li[1]")
    protected List<WebElement> LIST_OF_UNAVAILABLE_ITEMS;
    @FindBy(css = "*[class='catalog-settings__sorting'] > select")
    protected WebElement SORT_SELECT;
    @FindBy(xpath = "//option[text() = ' От дешевых к дорогим ']")
    protected WebElement FROM_CHEAP_TO_EXPENSIVE;

    public PurchasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public PurchasePage chooseFirstItem() {
        getElement().clickOnElement(ITEMS.get(0));
        return this;
    }

    public PurchasePage chooseSecondItem() {
        getElement().clickOnElement(ITEMS.get(1));
        return this;
    }

    public BasketPage buyItem() {
        getElement()
                .scrollToElement(SEARCH_BUTTON)
                .clickOnElement(BUY_BUTTON);
        return new BasketPage(webDriver);
    }

    public PurchasePage clickOnLaptopsButton() {
        getElement()
                .scrollToElement(LAPTOPS_BUTTON)
                .clickOnElement(LAPTOPS_BUTTON);
        return this;
    }

    public PurchasePage scrollToPriceBlockAndFillInFieldsPrices(String min, String max) {
        getElement()
                .scrollToElement(PRICE_OK_BUTTON)
                .searchFieldClearAndSendKey(PRICE_MINIMUM, min)
                .searchFieldClearAndSendKey(PRICE_MAXIMUM, max)
                .clickOnElement(PRICE_OK_BUTTON);
        return this;
    }

    public boolean isSuitInputPriceWithPriceAfterSort(String min, String max) {
        boolean isOverThenMin = Integer.parseInt(min) < getPriceAfterParse(PRICE_VALUE_OF_ITEMS.get(0));
        boolean isLessThenMax = Integer.parseInt(max) > getPriceAfterParse(PRICE_VALUE_OF_ITEMS.get(0));
        return isOverThenMin && isLessThenMax;
    }

    private Integer getPriceAfterParse(WebElement webElement) {
        return Integer.parseInt(getElement()
                .getTextFromElement(webElement)
                .replaceAll("\\s+", ""));
    }

    public boolean isExistMessageAboutProductNotFound() {
        return getElement().isElementExist(MESSAGE_ABOUT_NOT_FOUND);
    }

    public String getProductCode() {
        return getElement().getTextFromElement(PRODUCT_CODE);
    }

    public PurchasePage clickOnAddToCompareButton() {
        getElement()
                .scrollToElement(SEARCH_BUTTON)
                .clickOnElement(ADD_TO_COMPARE_BUTTON);
        return this;
    }

    public PurchasePage clickOnListOfComparesButton() {
        getElement().clickOnElement(LIST_OF_COMPARES);
        return this;
    }

    public ComparesPage chooseLaptopsCategoryFromListOfCompares() {
        getElement().clickOnElement(LAPTOPS_CATEGORY_FROM_COMPARES_LIST);
        return new ComparesPage(webDriver);
    }

    public PurchasePage clickOnReadyForDispatchButton() {
        getElement().clickOnElement(READY_FOR_DISPATCH_BUTTON);
        return this;
    }

    public boolean isAllItemsReadyForDispatch() {
        return ITEMS.size() == ITEMS_READY_FOR_DISPATCH.size();
    }

    public PurchasePage scrollAndClickOnUnavailableProductsButton() {
        getElement()
                .scrollToElement(UNAVAILABLE_BUTTON)
                .clickOnElement(UNAVAILABLE_BUTTON);
        return this;
    }

    public boolean isAllItemsUnavailable() {
        return ITEMS.size() == LIST_OF_UNAVAILABLE_ITEMS.size();
    }

    public PurchasePage clickOnSortSelectAndChooseFromCheapToExpensiveSelect() {
        getElement().clickOnElement(SORT_SELECT);
        getElement().clickOnElement(FROM_CHEAP_TO_EXPENSIVE);
        return this;
    }

    public boolean isSortedProductsFromCheapToExpensive() {
        return Ordering.natural().isOrdered(transformToPricesListFrom(PRICE_VALUE_OF_ITEMS));
    }

    private List<Integer> transformToPricesListFrom(List<WebElement> webElementList) {
        return webElementList
                .stream()
                .map(this::getPriceAfterParse)
                .collect(Collectors.toList());
    }
}
