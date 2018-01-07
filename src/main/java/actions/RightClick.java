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
public class RightClick {

    public static void main(String[] args) throws InterruptedException {
        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("http://www.google.com");
        WebElement searchBar = webdriver.findElement(By.name("q"));

        Actions builder = new Actions(webdriver);

        Action rightClick = builder.contextClick(searchBar).build();

        rightClick.perform();
    }
}
