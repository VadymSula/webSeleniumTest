package pages.more;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class VacanciesPage extends BasePage {
    @FindBy(xpath = "//option[contains(text(), 'Все направления')]/..")
    protected WebElement DIRECTION;
    @FindBy(xpath = "//option[contains(text(), 'IT')]")
    protected WebElement IT_DIRECTION;
    @FindBy(xpath = "//a[contains(text(), 'Показать')]")
    protected WebElement SHOW_VACANCIES_BUTTON;
    @FindBy(xpath = "//p[@class = 'vacancy__department ng-star-inserted']")
    protected List<WebElement> VACANCIES_DEPARTMENT;

    public VacanciesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public VacanciesPage clickOnDirectionButton() {
        getElement().clickOnElement(DIRECTION);
        return this;
    }

    public VacanciesPage chooseITDirectionOption() {
        getElement().clickOnElement(IT_DIRECTION);
        return this;
    }

    public VacanciesPage showVacanciesButton() {
        getElement().clickOnElement(SHOW_VACANCIES_BUTTON);
        return this;
    }

    public boolean isAllVacanciesFromListEqualsDirection(String nameOfDepartment) {
        return VACANCIES_DEPARTMENT
                .stream()
                .anyMatch(vacancy -> isNotEqualsNameOfDepartments(vacancy, nameOfDepartment));
    }

    private boolean isNotEqualsNameOfDepartments(WebElement nameBeforeSearch, String nameAfterSearch) {
        return !(getElement().getTextFromElement(nameBeforeSearch).trim()).equals(nameAfterSearch);
    }
}
