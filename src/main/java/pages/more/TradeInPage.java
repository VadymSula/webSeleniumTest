package pages.more;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class TradeInPage extends BasePage {
    @FindBy(xpath = "//*[@class = 'rz-title' and text() = 'Как воспользоваться?']")
    protected WebElement HOW_TO_USE_TITLE;
    @FindBy(xpath = "//*[@class = 'rz-title' and text() = 'Какие гаджеты можно обменять?']")
    protected WebElement GADGET_FOR_TRADE_IN_TITLE;
    @FindBy(xpath = "//*[@class = 'rz-conditions__list']/div")
    protected List<WebElement> TYPE_OF_DEVICE_SELECT;

    public TradeInPage(WebDriver webDriver) {
        super(webDriver);
    }
    public boolean isExistHowToUseTitle() {
        return getElement().isElementExist(HOW_TO_USE_TITLE);
    }

    public TradeInPage scrollToConditionsBlock() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", GADGET_FOR_TRADE_IN_TITLE);
        return this;
    }

    public boolean isExistGadgetsForTradeIn() {
        return TYPE_OF_DEVICE_SELECT.size() == 3;
    }
}
