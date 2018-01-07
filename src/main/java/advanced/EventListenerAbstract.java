package advanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 21/11/2016.
 */
public class EventListenerAbstract extends AbstractWebDriverEventListener {
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("test that the listener works");
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();


        EventFiringWebDriver eventDriver = new EventFiringWebDriver(webdriver);

        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        EventListenerAbstract eventListener = new EventListenerAbstract();

        eventDriver.register(eventListener);

        eventDriver.manage().window().maximize();
        eventDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        eventDriver.get("http://google.com");
        eventDriver.navigate().refresh();
        eventDriver.quit();
    }
}
