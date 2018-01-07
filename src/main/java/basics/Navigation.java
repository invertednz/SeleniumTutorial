package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 25/10/2016.
 */
public class Navigation {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*
        When opening a url you can use either webdriver.navigate.to or webdriver.get.  Both do the same thing.

        WebDriver will wait until the page has fully loaded (that is, the onload event has fired) before returning control to your test or script.
        It’s worth noting that if your page uses a lot of AJAX on load then WebDriver may not know when it has completely loaded. If you need to
        ensure such pages are fully loaded then you can use waits.
         */
        webdriver.navigate().to("http://google.com");

        //the webpage needs to include the http:// or https:// prefix.
        //webdriver.navigate().to("http://www.google.com");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.get("http://www.stackoverflow.com");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.navigate().back();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.navigate().forward();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.navigate().refresh();
    }
}
