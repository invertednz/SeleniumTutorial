package basics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jfarrier on 23/11/2016.
 */
public class ExecuteJavascript {

    public static void inViewOnThePage(WebDriver driver, WebElement todoListItem) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + todoListItem.getLocation().getY() + ")");
    }
}
