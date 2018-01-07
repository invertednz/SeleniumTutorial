package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by jfarrier on 8/11/2016.
 */
public class Drag {
    /*
    Drag and drop is a very common feature. It is when you "grab" an object and drag it to a different location.

    In Webdriver to drag elements we use the Builder pattern, which allows us to 'build' up a set of actions to perform

    For more information see - http://www.w3schools.com/html/html5_draganddrop.asp
     */

    public static void main(String[] args) {
        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("http://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop");

        webdriver.switchTo().frame("iframeResult");

        WebElement w3schoolsIcon = webdriver.findElement(By.id("drag1"));
        WebElement toLocation = webdriver.findElement(By.id("div1"));
        w3schoolsIcon.click();
        Actions builder = new Actions(webdriver);
        Action dragAndDrop = builder
                //.dragAndDrop(w3schoolsIcon, toLocation)
                .clickAndHold(w3schoolsIcon)
                .moveToElement(toLocation)
                .release(toLocation)
                .build();

        dragAndDrop.perform();

        //currently there is an issue with some drag and drops
        //issue - https://code.google.com/p/selenium/issues/detail?id=6315
        //work around javascript - https://gist.github.com/rcorreia/2362544

        //read the javascript file
        //execute_script(dnd_javascript+"$('#column-a').simulateDragDrop({ dropTarget: '#column-b'});")
    }
}
