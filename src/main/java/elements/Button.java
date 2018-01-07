package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 17/10/2016.
 */
public class Button {

    public static void main(String[] args) {
        //Buttons can be both button and input html elements

        //For more information on input elements see - http://www.w3schools.com/tags/tag_input.asp

        //For more information on button elements see - http://www.w3schools.com/tags/tag_button.asp
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        webdriver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_form_submit");

        webdriver.switchTo().frame("iframeResult");

        WebElement submitButton = webdriver.findElement(By.xpath("//input[@value = 'Submit']"));

        System.out.println("getAttribute = " + submitButton.getAttribute("type"));
        System.out.println("getText = " + submitButton.getText());
        System.out.println("getTagName = " + submitButton.getTagName());
        System.out.println("getSize = " + submitButton.getSize().getHeight());
        System.out.println("getLocation = " + submitButton.getLocation().x);
        System.out.println("isDisplayed = " + submitButton.isDisplayed());
        System.out.println("isEnabled = " + submitButton.isEnabled());
        System.out.println("isSelected = " + submitButton.isSelected());

        submitButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_form_submit");
        webdriver.switchTo().frame("iframeResult");
        submitButton = webdriver.findElement(By.xpath("//input[@value = 'Submit']"));

        submitButton.submit();

        //*/
        /*
        webdriver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_test");

        webdriver.switchTo().frame("iframeResult");

        WebElement clickMe = webdriver.findElement(By.tagName("Button"));

        System.out.println("getAttribute = " + clickMe.getAttribute("type"));
        System.out.println("getText = " + clickMe.getText());
        System.out.println("getTagName = " + clickMe.getTagName());
        System.out.println("getSize = " + clickMe.getSize().getHeight());
        System.out.println("getLocation = " + clickMe.getLocation().x);
        System.out.println("isDisplayed = " + clickMe.isDisplayed());
        System.out.println("isEnabled = " + clickMe.isEnabled());

        //Selected is not whether the element is in focus (has been tabbed to or not/where the cursor is )
        System.out.println("isSelected = " + clickMe.isSelected());


        clickMe.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webdriver.switchTo().alert().dismiss();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_test");
        webdriver.switchTo().frame("iframeResult");
        clickMe = webdriver.findElement(By.tagName("Button"));

        //exception thrown as you can't submit a button element.
        clickMe.submit();
        */
        webdriver.quit();

    }
}
