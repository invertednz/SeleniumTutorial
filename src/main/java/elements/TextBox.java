package elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 17/10/2016.
 */
public class TextBox {
    public static void main(String[] args){
        //Text Boxes on forms are usually input html elements.  Which have a type of "text".
        //For more information on input elements see - http://www.w3schools.com/tags/tag_input.asp

        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_form_submit");

        webdriver.switchTo().frame("iframeResult");

        WebElement firstNameField = webdriver.findElement(By.name("FirstName"));

        /*
        getAttribute Command
        getAttribute(String Name) : String– This method gets the value of the given attribute of the element. This accepts the String as a parameter and returns a String value.

        Command – element.getAttribute();

        Attributes are Ids, Name, Class extra and using this method you can get the value of the attributes of any given element.
         */
        System.out.println("getAttribute = " + firstNameField.getAttribute("type"));

        /*
        GetText Command
        getText( ) : String– This method will fetch the visible (i.e. not hidden by CSS) innerText of the element. This accepts nothing as a parameter but returns a String value.

        Command – element.submit();

        This returns an innerText of the element, including sub-elements, without any leading or trailing whitespace.
         */
        System.out.println("getText = " + firstNameField.getText());

        /*
        getTagName( ) : String– This method gets the tag name of this element. This accepts nothing as a parameter and returns a String value.

        Command – element.getTagName();

        This does not return the value of the name attribute but return the tag for e.g. “input“ for the element <input name="foo"/>.
         */
        System.out.println("getTagName = " + firstNameField.getTagName());

        /*
        getSize Command
        getSize( ) : Dimension – This method fetch the width and height of the rendered element. This accepts nothing as a parameter but returns the Dimension object.

        Command – element.getSize();

        This returns the size of the element on the page.
         */
        System.out.println("getSize = " + firstNameField.getSize().getHeight());

        /*
        getLocation Command
        getLocation( ) : Point – This method locate the location of the element on the page. This accepts nothing as a parameter but returns the Point object.

        Command – element.getLocation();

        This returns the Point object, from which we can get X and Y coordinates of specific element.
         */
        System.out.println("getLocation = " + firstNameField.getLocation().x);

        /*
        IsDisplayed Command
        isDisplayed( ) : boolean – This method determines if an element is currently being displayed or not. This accepts nothing as a parameter but returns boolean value(true/false).

        Command – element.isDisplayed();

        REWRITE - Do not confuse this method with element present on the page or not. This will return true if the element is present on the page and throw a NoSuchElementFound exception if the element is not present on the page. This refers the property of the element, sometimes the element is present on the page but the property of the element is set to hidden, in that case this will return false, as the element is present in the DOM but not visible to us.
         */
        System.out.println("isDisplayed = " + firstNameField.isDisplayed());

        /*
        IsEnabled Command
        isEnabled( ) : boolean – This determines if the element currently is Enabled or not? This accepts nothing as a parameter but returns boolean value(true/false).

        Command – element.isEnabled();

        REWRITE - This will generally return true for everything but I am sure you must have noticed many disabled input elements in the web pages.
         */
        System.out.println("isEnabled = " + firstNameField.isEnabled());

        /*
        IsSelected Command
        isSelected( ) : boolean – Determine whether or not this element is selected or not. This accepts nothing as a parameter but returns boolean value(true/false).

        Command – element.isSelected();

        This is not the active element/focused element
        REWRITE - This operation only applies to input elements such as Checkboxes, Select Options and Radio Buttons. This returns True if the element is currently selected or checked, false otherwise.
        */
        System.out.println("isSelected = " + firstNameField.isSelected());

        /*
        Click Command
        click( ) : void – This simulates the clicking of any element. Accepts nothing as a parameter and returns nothing.

        Command – element.click();

        Clicking is perhaps the most common way of interacting with web elements like text elements, links, radio boxes and many more.

        After clicking if a new webpage is opened webdriver will wait until the page has fully loaded (in the same way as navigation).
        However if the new page is created via javascript this will not be the case.

        In order for an element to be clicked it must be visible and have a height and width greater than 0.
         */
        firstNameField.click();
        System.out.println("after click isSelected = " + firstNameField.isSelected());


        /*
        Clear Command
        clear( ) : void – If this element is a text entry element, this will clear the value. This method accepts nothing as a parameter and returns nothing.

        Command – element.clear();

        This method has no effect on other elements. Text entry elements are INPUT and TEXTAREA elements.
         */
        firstNameField.clear();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        SendKeys Command
        sendKeys(CharSequence… keysToSend ) : void – This simulate typing into an element, which may set its value. This method accepts CharSequence as a parameter and returns nothing.

        Command – element.sendKeys(“text”);

        This method works fine with text entry elements like INPUT and TEXTAREA elements.
         */
        firstNameField.sendKeys("Minnie");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        firstNameField.sendKeys("Mickey");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        /*
        Submit Command
        submit( ) : void– This method works well/better than the click() if the current element is a form, or an element within a form. This accepts nothing as a parameter and returns nothing.

        Command – element.submit();

        If this causes the current page to change, then this method will wait until the new page is loaded.
         */
        firstNameField.submit();
        ///webdriver.quit();

    }
}
