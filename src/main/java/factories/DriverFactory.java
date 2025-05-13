package factories;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory{

    public static WebDriver launch(Browser browser) {
        if (browser.equals(Browser.CHROME)) {
            return new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            return new FirefoxDriver();
        } else if (browser.equals(Browser.EDGE)) {
            return new EdgeDriver();
        }

        // default
        return new ChromeDriver();
    }
}
