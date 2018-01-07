package advanced.pageobjects.tests;

import advanced.pageobjects.pages.github.GitHubLoginPageFluent;
import advanced.pageobjects.pages.github.GitHubUserPage;
import advanced.pageobjects.pages.todomvc.ApplicationPageFunctional;
import advanced.pageobjects.pages.todomvc.ApplicationPageFunctionalFluent;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import advanced.pageobjects.domain.TodoMVCUser;

public class NoAbstractionTest {

    private WebDriver driver;
    String siteURL;

    @Before
    public void startDriver(){
        driver = new FirefoxDriver();

        // admittedly the line below is an abstraction but it allows me to
        // run the tests locally more easily. It is the only abstraction
        // used in this test class though
        siteURL = "http://todomvc.com/examples/backbone/";
    }

    @Test
    public void canCreateAToDoWithNoAbstraction(){

        driver.get(siteURL);

        int originalNumberOfTodos = driver.findElements(
                By.cssSelector("ul.todo-list li")).size();

        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        createTodo.sendKeys("new task");
        createTodo.sendKeys(Keys.ENTER);

        assertThat(driver.findElement(
                By.className("filters")).isDisplayed(), is(true));

        int newToDos = driver.findElements(
                By.cssSelector("ul.todo-list li")).size();

        assertThat(newToDos, greaterThan(originalNumberOfTodos));
    }

    @After
    public void stopDriver(){
        driver.close();
        driver.quit();
    }

    @Test
    public void canCreateAToDoWithAbstractionAndUser(){
        WebDriver driver = new FirefoxDriver();
        TodoMVCUser user = new TodoMVCUser(driver);

        user.opensApplication().and().createNewToDo("new task");

        ApplicationPageFunctional page =
                new ApplicationPageFunctional(driver);

        assertThat(page.getCountOfTodoDoItems(), is(1));
        assertThat(page.isFooterVisible(), is(true));

        driver.close();
        driver.quit();
    }

    @Test
    public void canCreateAToDoWithAbstraction(){
        WebDriver driver = new FirefoxDriver();
        TodoMVCUser user = new TodoMVCUser(driver);

        ApplicationPageFunctional page =
                new ApplicationPageFunctional(driver);

        page.get();
        page.enterNewToDo("new task");

        assertThat(page.getCountOfTodoDoItems(), is(1));
        assertThat(page.isFooterVisible(), is(true));

        driver.close();
        driver.quit();
    }

    @Test
    public void canCreateAToDoWithAbstractionFluent(){
        WebDriver driver = new FirefoxDriver();
        TodoMVCUser user = new TodoMVCUser(driver);

        ApplicationPageFunctionalFluent page =
                new ApplicationPageFunctionalFluent(driver);

        page.get().enterNewToDo("new task");

        assertThat(page.getCountOfTodoDoItems(), is(1));
        assertThat(page.isFooterVisible(), is(true));

        driver.close();
        driver.quit();
    }

    @Test
    public void implicitWaitExample(){

        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);

        driver.get(siteURL);

        int originalNumberOfTodos = driver.findElements(
                By.cssSelector("ul.todo-list li")).size();

        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        createTodo.sendKeys("new task");
        createTodo.sendKeys(Keys.ENTER);

        assertThat(driver.findElement(
                By.className("filters")).isDisplayed(), is(true));

        int newToDos = driver.findElements(
                By.cssSelector("ul.todo-list li")).size();

        assertThat(newToDos, greaterThan(originalNumberOfTodos));
    }

    @Test
    public void explicitWaitExample(){

        driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,15);

        driver.get(siteURL);

        int originalNumberOfTodos = driver.findElements(
                By.cssSelector("ul.todo-list li")).size();

        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        createTodo.sendKeys("new task");
        createTodo.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(By.className("filters")));

        int newToDos = driver.findElements(
                By.cssSelector("ul.todo-list li")).size();

        assertThat(newToDos, greaterThan(originalNumberOfTodos));
    }

    //Test to determine number of repositories
    @Test
    public void loginTestFluentValidLogin1(){
        GitHubLoginPageFluent loginPage = new GitHubLoginPageFluent(driver);
        loginPage.login("test", "test");
        GitHubUserPage userPage = new GitHubUserPage(driver);
        //or
        ((GitHubUserPage)loginPage.login("test", "test")).numberOfRepositories();
        Assert.assertEquals(-1, userPage.numberOfRepositories());
    }

    @Test
    public void loginTestFluentValidLogin2(){
        GitHubLoginPageFluent loginPage = new GitHubLoginPageFluent(driver);
        ((GitHubUserPage)loginPage.validLogin("test", "test")).numberOfRepositories();
        //or
        GitHubUserPage userPage = loginPage.validLogin("test", "test");
    }
}