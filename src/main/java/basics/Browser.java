package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 25/10/2016.
 */
public class Browser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.get("http://google.com");

        /*
        Get Title Command
        getTitle() : String – This method fetches the Title of the current page. Accepts nothing as a parameter and returns a String value.

        Command – driver.getTitle();

        As the return type is String value, the output must be stored in String object/variable.
         */
        System.out.println(webdriver.getTitle());

        /*
        Get Current URL Command
        getCurrentUrl() : String – This method fetches the string representing the Current URL which is opened in the browser. Accepts nothing as a parameter and returns a String value.

        Command – driver.getCurrentTitle();

        As the return type is String value, the output must be stored in String object/variable.
         */
        System.out.println(webdriver.getCurrentUrl());

        /*
        Get Page Source Command
        getPageSource() : String – This method returns the Source Code of the page. Accepts nothing as a parameter and returns a String value.

        Command – driver.getPageSource();

        As the return type is String value, the output must be stored in String object/variable.
         */
        System.out.println(webdriver.getPageSource());

        /*
        Close Command
        close() : void – This method Close only the current window the WebDriver is currently controlling. Accepts nothing as a parameter and returns nothing.

        Command – driver.close();

        Quit the browser if it’s the last window currently open.
         */
        webdriver.close();

        /*
        Quit Command
        quit() : void – This method Closes all windows opened by the WebDriver. Accepts nothing as a parameter and returns nothing.

        Command – driver.quit();

        Close every associated window.
         */
        webdriver.quit();
    }
}
