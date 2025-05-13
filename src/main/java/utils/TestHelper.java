package utils;

import config.Config;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestHelper {
    public static String captureScreenshot(WebDriver driver, String testName) {
        String dateFormat = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotPath = Config.SCREENSHOT_PATH + testName + "_" + dateFormat + ".png";

        try {
            File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(screenshotPath));
            return screenshotPath;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to capture screenshot: " + e.getMessage();
        }
    }
}