package pages.purchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class BasketPage extends BasePage {
    @FindBy(className = "cart-product__title")
    protected WebElement CART_PRODUCT;
    @FindBy(id = "cartProductActions0")
    protected WebElement MORE_ACTIONS_BUTTON;
    @FindBy(xpath = "//li[@class='context-menu__item']/rz-trash-icon/button")
    protected WebElement DELETE_FROM_BASKET_BUTTON;
    @FindBy(xpath = "//div[@class='cart-dummy ng-star-inserted']/h4")
    protected WebElement BASKET_IS_EMPTY_INFO;
    @FindBy(css = " div[class = 'cart-counter'] > input")
    protected WebElement ITEMS_COUNTER;
    @FindBy(xpath = "//p[contains(text(), 'Товар')]")
    protected WebElement INVALID_COUNT_OF_ITEMS_MESSAGE;

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isExistElementInBasket() {
        return getElement().isElementExist(CART_PRODUCT);
    }

    public boolean isExistNameOfElementBasket(String nameElement) {
        String nameFromBasket = getElement().getTextFromElement(CART_PRODUCT);
        return nameFromBasket.contains(nameElement);
    }

    public BasketPage clickOnMoreActionsButton() {
        getElement().clickOnElement(MORE_ACTIONS_BUTTON);
        return this;
    }

    public BasketPage deleteProductFromBasket() {
        getElement().clickOnElement(DELETE_FROM_BASKET_BUTTON);
        return this;
    }

    public boolean isExistInfoMessageWithText(String text) {
        boolean isExistMessage = getElement().isElementExist(BASKET_IS_EMPTY_INFO);
        String textFromMessageInfo = getElement().getTextFromElement(BASKET_IS_EMPTY_INFO);

        return isExistMessage && textFromMessageInfo.equals(text);
    }

    public BasketPage fillInZeroInFieldForItemsQuantity() {
        getElement().searchFieldClearAndSendKey(ITEMS_COUNTER, "0");
        return this;
    }

    public boolean isExistMessageAboutInvalidCountOfItems() {
        return getElement().isElementExist(INVALID_COUNT_OF_ITEMS_MESSAGE);
    }
}
