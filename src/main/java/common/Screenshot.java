package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 22/11/2016.
 */
public class Screenshot {

    /*
    Exercice - Turn taking screenshots into two methods: one which gives a generic name and one which has a name as an argument

    Improve the screenshotting to take a screenshot after drawing a border around an element.

    Amend the screenshotting method to work with Html Driver - http://stackoverflow.com/questions/36254656/not-able-to-take-screenshot-using-htmlunitdriver-selenium-webdriver-java
    or - https://groups.google.com/forum/#!msg/selenium-developers/PTR_j4xLVRM/k2yVq01Fa7oJ

     */

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.get("http://google.com");
        File src = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/test.png"));
        webdriver.quit();

    }
}
