package elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Element {
    private static final Logger logger = Logger.getLogger(Element.class);
    private final WebDriver webDriver;

    public Element(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOnElement(WebElement webElement) {
        WebElement searchButton = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(webElement));

        searchButton.click();
    }

    public void clickOnElementWithWait(WebElement webElement, Long durationOfSeconds) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(durationOfSeconds));
        webElement.click();
    }

    public String getTextFromElement(WebElement webElement) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public boolean isVisibleElement(WebElement webElement) {
        try {
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(webElement));
            logger.info("Checking Element");
            return true;
        } catch (Exception ElementNotVisible) {
            return false;
        }
    }

    public Element searchFieldAndSendKey(WebElement webElement, String key) {
        WebElement searchField = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(webElement));
        searchField.sendKeys(key);
        return this;
    }

    public Element searchFieldClearAndSendKey(WebElement webElement, String key) {
        WebElement searchField = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(webElement));
        searchField.clear();
        searchField.sendKeys(key);
        return this;
    }

    public boolean isElementExist(WebElement element) {
        boolean isElementExist;

        try {
            isElementExist = element.isDisplayed();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            isElementExist = false;
        }

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return isElementExist;
    }

    public Element scrollToElement(WebElement webElement) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement);
        actions.perform();
        return this;
    }
}
