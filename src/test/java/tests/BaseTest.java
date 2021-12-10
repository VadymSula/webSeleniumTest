package tests;

import config.ConfigProperties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;

import java.time.Duration;

public class BaseTest {
    private static final Logger log = Logger.getLogger(BaseTest.class);
    private final WebDriver webDriver = initWebDriver();
    protected BasePage basePage;

    @BeforeSuite
    public void setup() {
        getWebDriver()
                .manage()
                .window()
                .maximize();
        getWebDriver()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
        getWebDriver().get(ConfigProperties.getProperty("mainPage"));
        basePage = new BasePage(getWebDriver());
    }

    @AfterClass
    public void tearDown() {
        getWebDriver().quit();
    }

    public WebDriver initWebDriver() {
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromeDriver"));
        return new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
