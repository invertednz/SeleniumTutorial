package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 17/10/2016.
 */
public class Dropdown {
    public static void main(String[] args) {
        /*
        The <select> element is used to create a drop-down list.

        The <option> tags inside the <select> element define the available options in the list.

        For more information check - http://www.w3schools.com/tags/tag_select.asp
         */


        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");

        webdriver.switchTo().frame("iframeResult");

        WebElement selectElement = webdriver.findElement(By.tagName("select"));

        System.out.println("getAttribute = " + selectElement.getAttribute("value"));
        System.out.println("getText = " + selectElement.getText());
        System.out.println("getTagName = " + selectElement.getTagName());
        System.out.println("getSize = " + selectElement.getSize().getHeight());
        System.out.println("getLocation = " + selectElement.getLocation().x);
        System.out.println("isDisplayed = " + selectElement.isDisplayed());
        System.out.println("isEnabled = " + selectElement.isEnabled());
        System.out.println("isSelected = " + selectElement.isSelected());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectElement.click();

        System.out.println("isSelected after clicking = " + selectElement.isSelected());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //both clear and sendKeys will throw errors
        //selectElement.clear();
        selectElement.sendKeys("Saab");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //submit will throw an error as the element is not in a form.
        //selectElement.submit();


        //alternatively you can create a select object
        Select select = new Select(selectElement);
        //select objects have various methods attached to them for interacting with select type elements
        select.selectByValue("audi");
        select.selectByVisibleText("Opel");

        webdriver.quit();
    }
}
