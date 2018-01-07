package browsers;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 25/10/2016.
 */
public class Chrome {

    //https://sites.google.com/a/chromium.org/chromedriver/capabilities
    //https://sites.google.com/a/chromium.org/chromedriver/downloads
    //https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities#safari-specific

    //ignore zoom settings ?

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("pathtoextension"));
        options.addArguments("user-data-dir=/path/to/your/custom/profile");
        options.addArguments("start-maximized");
        options.setBinary("/path/to/other/chrome/binary");

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_settings.popups", 0);
        options.setExperimentalOption("prefs", prefs);

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("myhttpproxy:3337");
        caps.setCapability("proxy", proxy);

        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("binary", "/usr/lib/chromium-browser/chromium-browser");

        //https://sites.google.com/a/chromium.org/chromedriver/mobile-emulation

        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Google Nexus 5");


        chromeOptions.put("mobileEmulation", mobileEmulation);


        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        WebDriver driver = new ChromeDriver(caps);

        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.get("http://google.com");
    }
}
