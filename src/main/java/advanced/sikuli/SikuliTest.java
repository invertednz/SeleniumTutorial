package advanced.sikuli;

/**
 * Created by james on 13/06/2017.
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.*;

//https://github.com/dzaiats/appium-sikuli-driver
//sikuli webdriver, does this still work - hasn't been updated in a long time

//be careful with sikuli and running remotely... or with multiple on the same machine
//check out https://stackoverflow.com/questions/26032706/how-to-get-sikuli-working-in-headless-mode

public class SikuliTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("http://www.google.com");
        Pattern image = new Pattern("c:/webdriver/googlesearchbox.png");
        Screen s = new Screen();
        Match m = s.exists(image);
        if(m != null){
            try {
                s.click(image);
            } catch (FindFailed findFailed) {
                findFailed.printStackTrace();
            }
        }else{
            System.out.println("image not found");
        }
        s.type("test");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s = new Screen();
        try {
            s.click(new Pattern("c:/webdriver/googlebutton2.png"));
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
}
