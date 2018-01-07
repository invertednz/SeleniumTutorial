package basics;

import com.google.common.base.Function;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



/**
 * Created by jfarrier on 25/10/2016.
 *
 * From -http://sqa.stackexchange.com/questions/12866/how-fluentwait-is-different-from-webdriverwait
 *
 * To learn more - http://seleniumsimplified.com/2012/08/fluentwait-with-webelement/
 */
public class Waits {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        /*
        Implicit waits are set at a webdriver level.  Webdriver/Selenium will wait until
        the implicit timeout is hit before throwing an exception.

        Below will mean that webdriver will wait at most 10 seconds before throwing an exception, i.e.
        if an element is not available.  Elements can be found earlier than the 10 second timeout.

        The behaviour of implicit wait is not fully defined and only works on find element methods.

        Note - that if you are checking for the absence of an element you will wait for the timeout to be hit.
        As such it is best pratice to avoid implicit waits where possible.
         */
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.get("http://google.com");



        /*
        Explicit wait allows you to define a certain condition which must occur before proceeding further in the code.
        WebDriverWait by default calls the ExpectedCondition every 500 milliseconds until it returns successfully.

        You should use Explicit Wait if element takes a long time to load or you are waiting on a state/property change (presence, clickability. etc).

        Note - can define absence of an element as a success condition.  You can also customize delay between retries and exceptions to ignore.
         */
        WebElement myDynamicElement = (new WebDriverWait(webdriver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("a")));


        /*
        Fluent waits are more customizable versions of the Explicit wait.  You are able to specify.

        Frequency of checking the expected condition..
        Exceptions to ignore such as NoSuchElementExceptions while searching for an element on the page.
        Maximum amount of time to wait for a condition

        When to use FluentWait: When you try to test the presence of an element that may appear after every x seconds/minutes.
        It gives you more control, especially over which exceptions to ignore.
         */


        /*
        Step-1: Fluent Wait starts with capturing the start time to determine delay.
        Step-2: Fluent Wait then checks the condition defined in the until() method.
        Step-3: If the condition fails, Fluent Wait makes the application to wait as per the value set by the <pollingEvery(5, SECONDS)> method call. Here in this example, it’s 5 seconds.
        Step-4: After the wait defined in Step 3 expires, start time is checked against the current time. If the difference of the wait start time (set in step-1) and the current time is less than the time set in <withTimeout(30, SECONDS)> method, then Step-2 will need to repeat.


        Other examples - http://seleniumsimplified.com/2012/08/fluentwait-with-webelement/
                        http://www.techbeamers.com/webdriver-fluent-wait-command-examples/
        */
        Wait wait = new FluentWait(webdriver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        WebElement foo = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webdriver) {
                return webdriver.findElement(By.id("foo"));
            }
        });


        wait.until(new Function<WebElement, Boolean>() {
            public Boolean apply(WebElement foo) {
                return foo.isDisplayed();
            }
        });


        /*
        Hand written wait
         */
        WebElement ele = null;
        long time = System.currentTimeMillis();
        long timeoutInMilli = 10000; //10 seconds
        long pollingInMilli = 100;
        while(ele==null&&System.currentTimeMillis()<time+timeoutInMilli){
            try{
                ele = webdriver.findElement(By.tagName("a"));
                Thread.sleep(pollingInMilli);
            }catch(Exception e){}
        }
    }
}
