package elements.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 17/10/2016.
 */
public class Frame {
    public static void main(String[] args) {
        //The <frame> tag defines one particular window (frame) within a <frameset>.  Frames are not available (deprecated) in html 5.

        //For more information check - http://www.w3schools.com/tags/tag_frame.asp

        /*
        The <iframe> tag specifies an inline frame.

        An inline frame is used to embed another document within the current HTML document.

        For more information see - http://www.w3schools.com/tags/tag_iframe.asp

        Webdriver/Selenium treats frames and iframes in the same way.

        */



        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to("http://www.w3schools.com/TAGS/tryit.asp?filename=tryhtml_input_checked");

        webdriver.switchTo().frame("iframeResult");

        WebElement bikeCheckBox = webdriver.findElement(By.name("vehicle"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bikeCheckBox.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.switchTo().defaultContent();

        webdriver.switchTo().frame("iframeResult");

        bikeCheckBox = webdriver.findElement(By.name("vehicle"));
        bikeCheckBox.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.switchTo().defaultContent();

        webdriver.switchTo().frame(2);

        bikeCheckBox = webdriver.findElement(By.name("vehicle"));
        bikeCheckBox.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.switchTo().defaultContent();
        List<WebElement> frames = webdriver.findElements(By.tagName("iframe"));

        webdriver.switchTo().frame(frames.get(2));

        bikeCheckBox = webdriver.findElement(By.name("vehicle"));
        bikeCheckBox.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");

        webdriver.switchTo().frame("iframeResult");

        webdriver.switchTo().frame(0);

        System.out.println(webdriver.getTitle());

        System.out.println(webdriver.findElement(By.xpath("//p")).getText());

        webdriver.quit();
    }
}
