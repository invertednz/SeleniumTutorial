package elements.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by jfarrier on 21/11/2016.
 */
public class Colour {
    public static void main(String[] args) throws InterruptedException {
        /*
            TODO
            http://www.w3schools.com/jsref/prop_style_backgroundcolor.asp
            http://www.w3schools.com/html/html_css.asp
            http://www.w3schools.com/html/html_colors.asp
         */


        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("http://www.google.com");

        WebElement element = webdriver.findElement(By.xpath("//input[@value = 'Google Search']"));
        WebElement body = webdriver.findElement(By.id("viewport"));
        ((JavascriptExecutor) webdriver).executeScript("document.body.style.backgroundColor = 'lightblue'");
        Thread.sleep(5000);
        ((JavascriptExecutor) webdriver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "color: black; border: 10px solid black; background-color: yellow;");
        System.out.println(element.getCssValue("background-color"));
    }
}
