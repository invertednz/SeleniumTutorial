package advanced.loadablecomponent.pageobjects;

import advanced.loadablecomponent.setup.PageLoadHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

import static advanced.loadablecomponent.setup.SeleniumDriver.getDriver;

/**
 * Created by sargis on 6/19/16.
 */
public class GitHubJoinPageSlow extends SlowLoadableComponent<GitHubJoinPageSlow>{
    @FindBy(id = "user_login")
    WebElement usernameField;

    @FindBy(id = "user_email")
    WebElement emailField;

    @FindBy(id = "user_password")
    WebElement passwordField;

    @FindBy(className = "flash-error")
    WebElement errorBox;

    @FindBy(id = "signup_button")
    WebElement joinButton;

    //timeout in seconds;

    public GitHubJoinPageSlow() {
        super(new SystemClock(), 5);
    }

    public void registerNewUser(String username, String email, String password) {

    }

    public boolean isLoginError() {
        return errorBox.isDisplayed();
    }


    @Override
    protected void load() {

    }


    @Override
    protected void isLoaded() throws Error {
        //no wait in this method as the wait is built into the SlowLoadable
        PageLoadHelper.isLoaded().whenElementIsEnabled(By.cssSelector("input[id='user_login']"));
    }
}