package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by jfarrier on 9/11/2016.
 */
public class BrokenLinks {
    /*
    Broken links are sometimes found in websites.  The below runs through all links on a page and then verifies that they are valid.

    This is a common function that you may want to use to increase the usefulness of your tests.

    Tutorial - Extend this to only verify visible elements.
    Extend this to verify that image sources are not broken.  - http://the-internet.herokuapp.com/broken_images
     */
    public static void main(String[] args) {
        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("http://www.google.com");

        //webdriver.switchTo().frame("iframeResult");

        List<WebElement> links = findLinksOnPage(webdriver);

        for(WebElement link : links){
            try{
                System.out.println("URL: " + link.getAttribute("href") + " returned " + verifyURL(new URL(link.getAttribute("href"))));
            }catch(Exception e){
                System.out.println("At " + link.getAttribute("innerHTML") + " Exception occured: " + e.getMessage());
            }
        }

    }

    private static String verifyURL(URL url) throws Exception{
        String response = "";

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try{
            connection.connect();
            response = connection.getResponseMessage();
            connection.disconnect();
            return response;
        }catch(Exception exp)
        {
            return exp.getMessage();
        }
    }

    private static List<WebElement> findLinksOnPage(WebDriver webdriver) {
        List<WebElement> links = webdriver.findElements(By.xpath("//*[@href]"));

        /*
        Could also grab all elements of certain types and add them to the list.

        i.e. links.addAll(webdriver.findElements(By.tagName("a")));
         */

        return links;
    }

}
