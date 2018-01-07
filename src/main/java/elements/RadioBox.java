package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 17/10/2016.
 */
public class RadioBox {
    public static void main(String[] args){
        /*
        <input type="radio"> defines a radio button.

        Radio buttons let a user select ONE of a limited number of choices:

        For more information check - http://www.w3schools.com/html/html_forms.asp
         */


        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_radio");

        webdriver.switchTo().frame("iframeResult");

        WebElement firstCheckBox = webdriver.findElement(By.tagName("input"));

        System.out.println("getAttribute = " + firstCheckBox.getAttribute("type"));
        System.out.println("getText = " + firstCheckBox.getText());
        System.out.println("getTagName = " + firstCheckBox.getTagName());
        System.out.println("getSize = " + firstCheckBox.getSize().getHeight());
        System.out.println("getLocation = " + firstCheckBox.getLocation().x);
        System.out.println("isDisplayed = " + firstCheckBox.isDisplayed());
        System.out.println("isEnabled = " + firstCheckBox.isEnabled());
        System.out.println("isSelected = " + firstCheckBox.isSelected());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        firstCheckBox.click();

        System.out.println("isSelected after clicking = " + firstCheckBox.isSelected());

        //webdriver.quit();
    }
}
