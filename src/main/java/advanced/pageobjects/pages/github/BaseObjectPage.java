package advanced.pageobjects.pages.github;

import advanced.loadablecomponent.setup.CustomLoadableComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static advanced.loadablecomponent.setup.SeleniumDriver.getDriver;


/**
 * Created by Sargis on 4/3/16.
 */

public abstract class BaseObjectPage {
    public WebDriver webdriver;
    private static final String BASE_URL = "https://github.com";

    public BaseObjectPage(WebDriver driver) {
        this.webdriver = driver;
    }

    public abstract String getPageUrl();

    public void open(String url) {
        webdriver.get(url);
    }

    public WebElement find(By locator) {
        return webdriver.findElement(locator);
    }

    public void type(By inputLocator, String text) {
        find(inputLocator).sendKeys(text);
    }

    public void type(WebElement input, String text) {
        input.sendKeys(text);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
