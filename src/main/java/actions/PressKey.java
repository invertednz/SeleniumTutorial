package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by jfarrier on 23/11/2016.
 */
public class PressKey {
    //https://github.com/SeleniumHQ/selenium/wiki/Advanced-User-Interactions

    public static void main(String[] args) throws InterruptedException {
        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("http://www.google.com");
        //WebElement searchBar = webdriver.findElement(By.name("q"));

        Actions builder = new Actions(webdriver);

        Action type = builder.sendKeys("q").build();
        /*
        Select multiple
        builder.keyDown(Keys.CONTROL)
       .click(someElement)
       .click(someOtherElement)
       .keyUp(Keys.CONTROL);

         */

        type.perform();


        Thread.sleep(5000);

        webdriver.get("http://www.google.com");
        Thread.sleep(2000);
        new Actions(webdriver).sendKeys("q").build().perform();


    }
}
