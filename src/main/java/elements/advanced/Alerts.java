package elements.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by jfarrier on 7/11/2016.
 */
public class Alerts {
    public static void main(String[] args) {
        /*
        The window object represents an open window in a browser.

        An inline frame is used to embed another document within the current HTML document.

        For more information see - http://www.w3schools.com/jsref/obj_window.asp
         */


        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

        webdriver.switchTo().frame("iframeResult");

        WebElement tryIt = webdriver.findElement(By.tagName("button"));
        tryIt.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webdriver.switchTo().alert().accept();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //unlike frames and windows don't need to switch back.
        tryIt.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webdriver.switchTo().alert().dismiss();

        //accept vs dismiss
        webdriver.get("http://the-internet.herokuapp.com/javascript_alerts");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tryIt = webdriver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        tryIt.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webdriver.switchTo().alert().accept();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //unlike frames and windows don't need to switch back.
        tryIt.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webdriver.switchTo().alert().dismiss();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webdriver.switchTo().alert().sendKeys("Test Alerts");
        webdriver.switchTo().alert().accept();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Authentication

        //Throws exception as the alert dialog is not javascript based.
        //webdriver.get("http://the-internet.herokuapp.com/basic_auth");
        //webdriver.switchTo().alert().dismiss();


        webdriver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
