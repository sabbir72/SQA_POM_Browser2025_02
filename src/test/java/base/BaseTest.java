package base;

import config.Config;
import enums.Browser;
import factories.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.TestHelper;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.launch(Browser.CHROME);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.PAGE_LOAD_TIMEOUT));
        driver.get(Config.BASE_URL);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TestHelper.captureScreenshot(driver, result.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }
}