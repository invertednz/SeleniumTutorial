package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 17/10/2016.
 */
public class TextArea {
    public static void main(String[] args){
        /*
        The <textarea> tag defines a multi-line text input control.

        A text area can hold an unlimited number of characters, and the text renders in a fixed-width font (usually Courier).

        For more information check - http://www.w3schools.com/tags/tag_textarea.asp
         */


        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_textarea");

        webdriver.switchTo().frame("iframeResult");

        WebElement textArea = webdriver.findElement(By.tagName("textarea"));

        System.out.println("getAttribute = " + textArea.getAttribute("type"));
        System.out.println("getText = " + textArea.getText());
        System.out.println("getTagName = " + textArea.getTagName());
        System.out.println("getSize = " + textArea.getSize().getHeight());
        System.out.println("getLocation = " + textArea.getLocation().x);
        System.out.println("isDisplayed = " + textArea.isDisplayed());
        System.out.println("isEnabled = " + textArea.isEnabled());
        System.out.println("isSelected = " + textArea.isSelected());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textArea.click();

        System.out.println("isSelected after clicking = " + textArea.isSelected());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        textArea.clear();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textArea.sendKeys("Minnie");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //error will be thrown as this is not part of a submission form
        textArea.submit();

        //webdriver.quit();

    }
}
