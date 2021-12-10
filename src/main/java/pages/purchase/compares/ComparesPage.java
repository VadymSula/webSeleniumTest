package pages.purchase.compares;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.purchase.PurchasePage;

import java.util.List;

public class ComparesPage extends PurchasePage {
    @FindBy(className = "comparison__heading")
    protected WebElement COMPARISON_HEADING;
    @FindBy(xpath = "//div[contains(text(), 'Недостаточно товаров')]")
    protected WebElement PRODUCTS_NOT_ENOUGH_MESSAGE;
    @FindBy(xpath = "//span[contains(text(), 'Добавить')]/..")
    protected WebElement ADD_MORE_MODEL_BUTTON;
    @FindBy(xpath = "//ul[@class='products-grid']/li")
    protected List<WebElement> LIST_OF_PRODUCTS_COMPARE;
    @FindBy(css = "a[class = 'product__heading']")
    protected WebElement FIRST_PRODUCT_IN_COMPARISON_LIST;
    @FindBy(id = "comparisonProductActions0")
    protected WebElement PRODUCT_MORE_ACTIONS_BUTTON;
    @FindBy(xpath = "//button[text() = ' Удалить ']")
    protected WebElement DELETE_BUTTON;
    @FindBy(xpath = "//p[contains(text(), 'Нет товаров')]")
    protected WebElement MESSAGE_NOT_EXIST_PRODUCTS;

    public ComparesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isExistComparisonHeading() {
        return getElement().isElementExist(COMPARISON_HEADING);
    }

    public boolean isExistProductsNotEnoughForCompareMessage() {
        return getElement().isElementExist(PRODUCTS_NOT_ENOUGH_MESSAGE);
    }

    public ComparesPage clickOnAddMoreModelButton() {
        getElement().clickOnElement(ADD_MORE_MODEL_BUTTON);
        return this;
    }

    public boolean isExistTwoProductsInTheCompareList() {
        return LIST_OF_PRODUCTS_COMPARE.size() == 2;
    }

    public PurchasePage clickOnFirstProductFromComparisonList() {
        getElement().clickOnElement(FIRST_PRODUCT_IN_COMPARISON_LIST);
        return new PurchasePage(webDriver);
    }

    public ComparesPage clickOnMoreActionsButton() {
        getElement().clickOnElement(PRODUCT_MORE_ACTIONS_BUTTON);
        return this;
    }

    public ComparesPage clickOnDeleteProductFromCompareListButton() {
        getElement().clickOnElement(DELETE_BUTTON);
        return this;
    }

    public boolean isExistMessageListOfComparesIsEmpty() {
        return getElement().isElementExist(MESSAGE_NOT_EXIST_PRODUCTS);
    }
}
