package pages.more;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HelpCenterPage extends BasePage {
    @FindBy(id = "query")
    protected WebElement QUERY_FIELD;
    @FindBy(name = "commit")
    protected WebElement QUERY_SUBMIT;
    @FindBy(xpath = "//a[contains(text(), 'Связаться с нами')]")
    protected WebElement CONTACT_US_BUTTON;
    @FindBy(className = "article-support-socials__list")
    protected WebElement LIST_OF_MESSENGERS;

    public HelpCenterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HelpCenterPage inputPhraseAndSubmit(String phrase) {
        getElement()
                .searchFieldAndSendKey(QUERY_FIELD, phrase)
                .clickOnElement(QUERY_SUBMIT);
        return this;
    }

    public HelpCenterPage scrollToContactUsButtonAndClick() {
        getElement()
                .scrollToElement(CONTACT_US_BUTTON)
                .clickOnElement(CONTACT_US_BUTTON);
        return this;
    }

    public boolean isExistListOfMessengers() {
        return getElement().isElementExist(LIST_OF_MESSENGERS);
    }
}
