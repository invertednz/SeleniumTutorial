package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 22/11/2016.
 */
public class Localization {
    /*
    Localization is defined as making a product, application or document content adaptable to meet the cultural, lingual and other requirements of a specific region or a locale.

    You could use a localization api like google translate and validate localization as the test runs.

    Or have the localization values in the testing scope.  Webdriver uses ASCII characters for localized strings.

    You can convert text to ASCII representation using http://docs.oracle.com/javase/1.4.2/docs/tooldocs/windows/native2ascii.html, which also has a maven plugin.

    When running a framework which tests localization the test suite would need to be configured to use the appropriate values, dependant on the language in use.
     */

    /*
    Exercise - Create a program which opens up google in German - ge, French - fr and Spanish based on an argument and verifies that the buttons on the search bar are correct for that language.
     */
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        options.addArguments("--lang=es");

        WebDriver webdriver = new ChromeDriver(options);

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.get("http://google.com");
        Thread.sleep(5000);
        WebElement searchBar = webdriver.findElement(By.id("lst-ib"));
        searchBar.sendKeys("espa\u00F1ol");
    }
}
