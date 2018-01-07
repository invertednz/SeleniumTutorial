package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 7/11/2016.
 */
public class FindElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webdriver.get("http://www.google.com");

        /*
        findElement
        Zero Matches : throws NoSuchElementException
        One Match : returns WebElement
        One+ Matches : returns the first WebElement matching the By clause
         */
        webdriver.findElement(By.xpath("//a"));

        /*
        findElements
        Zero Matches : return an empty list
        One Match : returns list of one WebElement only
        One+ Matches : returns list with all matching WebElements
         */
        webdriver.findElements(By.xpath("//a"));

        /*
        Uses either xpath or CSS selectors to find the element, traversing the DOM.
         */
        webdriver.findElement(By.xpath("//a"));
        webdriver.findElement(By.cssSelector("a"));

        /*
        Uses the tag name of the element to find the element
         */
        webdriver.findElement(By.tagName("a"));

        /*
        Uses the HTML element attributes to find the element.
         */
        webdriver.findElement(By.id("a"));
        webdriver.findElement(By.name("a"));
        webdriver.findElement(By.className("a"));

        /*
        Uses the anchor tag link name to find the element
         */
        webdriver.findElement(By.linkText("a"));
        webdriver.findElement(By.partialLinkText("a"));
    }
}
