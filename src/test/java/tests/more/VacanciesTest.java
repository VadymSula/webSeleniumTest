package tests.more;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class VacanciesTest extends BaseTest {

    @Test
    public void vacanciesAndDepartmentsTest() {
        boolean actualResult = basePage
                .clickOnMainMenu()
                .clickOnVacanciesButton()
                .clickOnDirectionButton()
                .chooseITDirectionOption()
                .showVacanciesButton()
                .isAllVacanciesFromListEqualsDirection("Направление IT");

        Assert.assertTrue(actualResult);
    }
}
