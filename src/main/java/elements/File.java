package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 17/10/2016.
 */
public class File {
    public static void main(String[] args) {
        /*
        The Input FileUpload object represents an HTML <input> element with type="file".

        For more information check - http://www.w3schools.com/jsref/dom_obj_fileupload.asp
         */


        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_create");

        webdriver.switchTo().frame("iframeResult");

        WebElement tryIt = webdriver.findElement(By.tagName("button"));
        tryIt.click();

        WebElement upload = webdriver.findElement(By.tagName("input"));
        //change the file location if you want to run this yourself.
        //uploads will not work in safari driver
        upload.sendKeys("c:/chromedriver.exe");

        //webdriver.quit();

    }
}
