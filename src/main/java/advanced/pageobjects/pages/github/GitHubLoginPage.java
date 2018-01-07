package advanced.pageobjects.pages.github;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object GitHub login page
 *
 * Created by Sargis on 4/3/16.
 */
public class GitHubLoginPage extends BaseObjectPage{

    @FindBy(id = "login_field")
    WebElement loginField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "commit")
    WebElement commitButton;

    @FindBy(className = "flash-error")
    WebElement errorBox;

    WebDriver webdriver;

    public GitHubLoginPage(WebDriver webdriver){
        super(webdriver);
    }

    public String getPageUrl() {
        return "/login";
    }

    public void login(String login, String password) {
        loginField.sendKeys((login));
        passwordField.sendKeys((password));
        commitButton.click();
    }

    public boolean isLoginError() {
        return (errorBox).isDisplayed();
    }

    public String getErrorMessage() {
        return errorBox.getText();
    }
}