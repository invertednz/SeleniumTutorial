package advanced.pageobjects.domain;
import advanced.pageobjects.pages.todomvc.ApplicationPageFunctional;
import advanced.pageobjects.pages.todomvc.ApplicationPageStructural;
import org.openqa.selenium.WebDriver;

/**
 * A high level user object which wraps 'user' functionality making a user focussed DSL without
 * bringing in Cucumber
 * It uses lower level abstractions as appropriate e.g. structural and functional pages
 */
public class TodoMVCUser {
    private final WebDriver driver;
    private final ToDoList todoList;


    public TodoMVCUser(WebDriver driver) {
        this.driver = driver;

        this.todoList = new ToDoList();
    }

    public TodoMVCUser opensApplication() {
        driver.get("http://todomvc.com/examples/backbone/");
        return this;
    }

    public TodoMVCUser createNewToDo(String toDoText) {
        todoList.addNewToDoItem(toDoText);

        ApplicationPageFunctional page = new ApplicationPageFunctional(driver);

        page.enterNewToDo(toDoText);

        return this;
    }

    public ToDoList getTodoList() {
        return todoList;
    }

    public TodoMVCUser deleteToDoAt(int positionInList) {
        todoList.deleteItemAtPosition(positionInList);

        ApplicationPageStructural structural = new ApplicationPageStructural(driver);

        structural.deleteTodoItem(positionInList);

        return this;
    }

    public TodoMVCUser and(){
        return this;
    }

    public TodoMVCUser completesToDo(String toDoText) {
        int position = todoList.getPositionOf(toDoText);

        ApplicationPageStructural structural = new ApplicationPageStructural(driver);
        structural.toggleCompletionOfItem(position);

        return this;
    }
}