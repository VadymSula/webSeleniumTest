package pages.purchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CatalogPage extends BasePage {
    private static final String ALCOHOL_AND_PRODUCTS = "Алкогольные напитки и продукты";

    @FindBy(xpath = "//*[.='" + ALCOHOL_AND_PRODUCTS + "']")
    protected WebElement CATEGORY_OF_PRODUCTS;
    @FindBy(xpath = "//h1[@class = 'portal__heading ng-star-inserted']")
    protected WebElement NAME_OF_CATEGORY_HEADING;

    public CatalogPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CatalogPage clickOnAlcoholAndProductsCategory() {
        getElement().clickOnElement(CATEGORY_OF_PRODUCTS);
        return this;
    }

    public boolean isFoundAlcoholCategory() {
        String textFromHeading = getElement().getTextFromElement(NAME_OF_CATEGORY_HEADING).trim();
        return textFromHeading.equals(ALCOHOL_AND_PRODUCTS);
    }
}
