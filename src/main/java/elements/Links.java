package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 17/10/2016.
 */
public class Links {
    public static void main(String[] args){
        /*
        Links are found in nearly all web pages. Links allow users to click their way from page to page.

        In HTML, links are defined with the <a> tag:

        For more information check - http://www.w3schools.com/html/html_links.asp
         */


        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_links_w3schools");

        webdriver.switchTo().frame("iframeResult");

        WebElement link = webdriver.findElement(By.tagName("a"));

        System.out.println("getAttribute = " + link.getAttribute("type"));
        System.out.println("getText = " + link.getText());
        System.out.println("getTagName = " + link.getTagName());
        System.out.println("getSize = " + link.getSize().getHeight());
        System.out.println("getLocation = " + link.getLocation().x);
        System.out.println("isDisplayed = " + link.isDisplayed());
        System.out.println("isEnabled = " + link.isEnabled());
        System.out.println("isSelected = " + link.isSelected());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        link.click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.navigate().to("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_links_image");

        webdriver.switchTo().frame("iframeResult");

         link = webdriver.findElement(By.tagName("a"));

        System.out.println("getAttribute = " + link.getAttribute("type"));
        System.out.println("getText = " + link.getText());
        System.out.println("getTagName = " + link.getTagName());
        System.out.println("getSize = " + link.getSize().getHeight());
        System.out.println("getLocation = " + link.getLocation().x);
        System.out.println("isDisplayed = " + link.isDisplayed());
        System.out.println("isEnabled = " + link.isEnabled());
        System.out.println("isSelected = " + link.isSelected());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        link.click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.quit();

    }
}
