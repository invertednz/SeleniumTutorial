package advanced.pageobjects.pages.github;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object GitHub login page
 *
 * Created by Sargis on 4/3/16.
 */
public class GitHubLoginPageFluent extends BaseObjectPage {

    @FindBy(id = "login_field")
    WebElement loginField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "commit")
    WebElement commitButton;

    @FindBy(className = "flash-error")
    WebElement errorBox;


    public GitHubLoginPageFluent(WebDriver webdriver){
        super(webdriver);
    }

    public String getPageUrl() {
        return "/login";
    }

    public BaseObjectPage login(String login, String password) {
        loginField.sendKeys((login));
        passwordField.sendKeys((password));
        commitButton.click();
        if(isLoginError())
            return this;
        return new GitHubUserPage(webdriver);
    }

    public GitHubUserPage validLogin(String login, String password){
        loginField.sendKeys((login));
        passwordField.sendKeys((password));
        commitButton.click();
        return new GitHubUserPage(webdriver);
    }

    public GitHubLoginPageFluent invalidLogin(String login, String password){
        loginField.sendKeys((login));
        passwordField.sendKeys((password));
        commitButton.click();
        return this;
    }

    public boolean isLoginError() {
        return (errorBox).isDisplayed();
    }

    public String getErrorMessage() {
        return errorBox.getText();
    }
}