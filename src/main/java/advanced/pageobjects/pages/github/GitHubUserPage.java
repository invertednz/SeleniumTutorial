package advanced.pageobjects.pages.github;

import advanced.loadablecomponent.pageobjects.GitHubLoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Page object GitHub home page.
 *
 * Created by Sargis on 4/3/16.
 */

public class GitHubUserPage extends BaseObjectPage {


    public GitHubUserPage(WebDriver webdriver) {
        super(webdriver);
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public advanced.loadablecomponent.pageobjects.GitHubLoginPage goToLoginPage() {
        return new advanced.loadablecomponent.pageobjects.GitHubLoginPage().openPage(GitHubLoginPage.class);
    }

    public int numberOfRepositories(){
        return -1;
    }

}
