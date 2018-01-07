package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 17/10/2016.
 */
public class Div {
    public static void main(String[] args){
        /*
        The <div> tag defines a division or a section in an HTML document.

        The <div> tag is used to group block-elements to format them with CSS.

        For more information check - http://www.w3schools.com/tags/tag_div.asp

        Div tags will interact similarly to other non interactive by default html elements.

        Please note any that any element could be interactive with associated javascript.

        The span tag works similarly to the div tag.

        See - http://www.w3schools.com/tags/tag_span.asp
         */


        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_div_test");

        webdriver.switchTo().frame("iframeResult");

        WebElement divElement = webdriver.findElement(By.tagName("div"));

        System.out.println("getAttribute = " + divElement.getAttribute("type"));
        System.out.println("getText = " + divElement.getText());
        System.out.println("getTagName = " + divElement.getTagName());
        System.out.println("getSize = " + divElement.getSize().getHeight());
        System.out.println("getLocation = " + divElement.getLocation().x);
        System.out.println("isDisplayed = " + divElement.isDisplayed());
        System.out.println("isEnabled = " + divElement.isEnabled());
        System.out.println("isSelected = " + divElement.isSelected());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        divElement.click();

        System.out.println("isSelected after clicking = " + divElement.isSelected());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //both clear and sendKeys will throw errors
        //divElement.clear();
        //divElement.sendKeys("Minnie");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        divElement.submit();

        webdriver.quit();

    }
}
