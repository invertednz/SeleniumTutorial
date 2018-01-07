package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 17/10/2016.
 */
public class Checkbox {
    public static void main(String[] args){
        //Check Boxes on forms are input html elements.  Which have a type of "checkbox".
        //For more information check - http://www.w3schools.com/TAGS/att_input_checked.asp

        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to("http://www.w3schools.com/TAGS/tryit.asp?filename=tryhtml_input_checked");

        webdriver.switchTo().frame("iframeResult");

        WebElement bikeCheckBox = webdriver.findElement(By.name("vehicle"));

        System.out.println("getAttribute = " + bikeCheckBox.getAttribute("type"));
        System.out.println("getText = " + bikeCheckBox.getText());
        System.out.println("getTagName = " + bikeCheckBox.getTagName());
        System.out.println("getSize = " + bikeCheckBox.getSize().getHeight());
        System.out.println("getLocation = " + bikeCheckBox.getLocation().x);
        System.out.println("isDisplayed = " + bikeCheckBox.isDisplayed());
        System.out.println("isEnabled = " + bikeCheckBox.isEnabled());
        System.out.println("isSelected = " + bikeCheckBox.isSelected());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bikeCheckBox.click();

        System.out.println("isSelected after clicking = " + bikeCheckBox.isSelected());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //bikeCheckBox.clear();
        bikeCheckBox.sendKeys("Minnie");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bikeCheckBox.submit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webdriver.quit();

    }
}
