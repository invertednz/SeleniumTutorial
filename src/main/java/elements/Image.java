package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 17/10/2016.
 */
public class Image {
    public static void main(String[] args) {
        /*
        In HTML, images are defined with the <img> tag.

        The <img> tag is empty, it contains attributes only, and does not have a closing tag.

        The src attribute specifies the URL (web address) of the image:

        For more information check - http://www.w3schools.com/tags/tag_img.asp and/or http://www.w3schools.com/html/html_images.asp

        Additionally inputs may also be images.

        See - http://www.w3schools.com/tags/att_input_src.asp
         */


        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_src");

        webdriver.switchTo().frame("iframeResult");

        WebElement imageElement = webdriver.findElement(By.xpath("//input[@type='image']"));

        System.out.println("getAttribute = " + imageElement.getAttribute("value"));
        System.out.println("getText = " + imageElement.getText());
        System.out.println("getTagName = " + imageElement.getTagName());
        System.out.println("getSize = " + imageElement.getSize().getHeight());
        System.out.println("getLocation = " + imageElement.getLocation().x);
        System.out.println("isDisplayed = " + imageElement.isDisplayed());
        System.out.println("isEnabled = " + imageElement.isEnabled());
        System.out.println("isSelected = " + imageElement.isSelected());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        imageElement.click();



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        webdriver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_src");
        webdriver.switchTo().frame("iframeResult");
        imageElement = webdriver.findElement(By.xpath("//input[@type='image']"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        imageElement.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webdriver.navigate().to("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_images_mountain");

        webdriver.switchTo().frame("iframeResult");

        imageElement = webdriver.findElement(By.tagName("img"));

        System.out.println("getAttribute = " + imageElement.getAttribute("src"));
        System.out.println("getText = " + imageElement.getText());
        System.out.println("getTagName = " + imageElement.getTagName());
        System.out.println("getSize = " + imageElement.getSize().getHeight());
        System.out.println("getLocation = " + imageElement.getLocation().x);
        System.out.println("isDisplayed = " + imageElement.isDisplayed());
        System.out.println("isEnabled = " + imageElement.isEnabled());
        System.out.println("isSelected = " + imageElement.isSelected());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        imageElement.click();

        webdriver.quit();
    }
}