package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by jfarrier on 9/11/2016.
 */
public class Hover {
    /*
    Hover is when you move the curser over an element and the element changes in some way.

    There are multiple ways to implement hover in webpages.

    If you are interested in knowing more please see - http://www.w3schools.com/jsref/event_onmouseover.asp or http://www.w3schools.com/cssref/sel_hover.asp

    Tutorial - http://www.w3schools.com/cssref/tryit.asp?filename=trycss_sel_hover
     */

    public static void main(String[] args) throws InterruptedException {
        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_onmouseover");

        webdriver.switchTo().frame("iframeResult");

        WebElement smiley = webdriver.findElement(By.tagName("img"));
        WebElement para = webdriver.findElement(By.tagName("p"));

        Thread.sleep(5000);

        Actions builder = new Actions(webdriver);
        Action hover = builder.moveToElement(smiley).build();
        hover.perform();
        Thread.sleep(2000);
        Action hoverOff = builder.moveToElement(para).build();
        hoverOff.perform();
    }
}
