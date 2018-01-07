package elements.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 21/10/2016.
 */
public class Window {

    public static void main(String[] args) {
        /*
        The window object represents an open window in a browser.

        An inline frame is used to embed another document within the current HTML document.

        For more information see - http://www.w3schools.com/jsref/obj_window.asp

         */



        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        webdriver.switchTo().frame("iframeResult");

        WebElement tryIt = webdriver.findElement(By.tagName("button"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String originalWindow = webdriver.getWindowHandle();

        System.out.println("original title = " + webdriver.getTitle());
        System.out.println("original window handle = " + webdriver.getWindowHandle());
        System.out.println("number of window handles = "+ webdriver.getWindowHandles().size());

        tryIt.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("current title = " + webdriver.getTitle());
        System.out.println("current window handle = " + webdriver.getWindowHandle());
        System.out.println("number of window handles = "+ webdriver.getWindowHandles().size());

        System.out.println("loop through all windows");

        for(String window: webdriver.getWindowHandles()){
            webdriver.switchTo().window(window);
            System.out.println("current title = " + webdriver.getTitle());
            System.out.println("current window handle = " + webdriver.getWindowHandle());
            System.out.println("number of window handles = "+ webdriver.getWindowHandles().size());
        }
        System.out.println("close window");

        //webdriver.close closes the current window.
        webdriver.close();

        //if we don't switch to a 'non closed' window an error will be thrown
        System.out.println("current title = " + webdriver.getTitle());
        System.out.println("current window handle = " + webdriver.getWindowHandle());
        System.out.println("number of window handles = "+ webdriver.getWindowHandles().size());

        webdriver.switchTo().window(originalWindow);


        //You are also able to interact with the window, resizing it and scrolling.
        webdriver.manage().window().maximize();
        webdriver.manage().window().setPosition(new Point(200,200));

        webdriver.quit();

    }
}
