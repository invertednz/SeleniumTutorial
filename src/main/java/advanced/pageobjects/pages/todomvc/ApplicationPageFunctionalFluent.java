package advanced.pageobjects.pages.todomvc;

import advanced.pageobjects.pages.StructuralEnums;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ApplicationPageFunctionalFluent {

    private ApplicationPageStructural structure;

    public ApplicationPageFunctionalFluent(WebDriver driver) {
        structure = new ApplicationPageStructural(driver);
    }

    public int getCountOfTodoDoItems() {
        return structure.getCountOfTodo(StructuralEnums.ItemsInState.VISIBLE);
    }

    public int getCountOfCompletedTodoDoItems() {
        return structure.getCountOfTodo(StructuralEnums.ItemsInState.VISIBLE_COMPLETED);
    }

    public int getCountOfActiveTodoDoItems() {
        return structure.getCountOfTodo(StructuralEnums.ItemsInState.VISIBLE_ACTIVE);
    }

    public String getLastToDoIext() {
        return structure.getToDoText(getCountOfTodoDoItems()-1);
    }

    public ApplicationPageFunctionalFluent enterNewToDo(String todoTitle) {
        // could be Keys.ENTER on 2.40.0 and below
        // but needs to be Keys.RETURN on 2.41.0
        structure.typeIntoNewToDo(todoTitle, Keys.RETURN);
        return this;
    }

    public ApplicationPageFunctionalFluent get() {
        structure.get();
        return this;
    }

    public boolean isFooterVisible() {
        return structure.isFooterVisible();
    }

    public boolean isMainVisible() {
        return structure.isMainVisible();
    }

    public ApplicationPageFunctionalFluent deleteLastToDo() {
        structure.deleteTodoItem(getCountOfTodoDoItems() - 1);
        return this;
    }

    public ApplicationPageFunctionalFluent editLastItem(String editTheTitleTo) {
        structure.editItem(getCountOfTodoDoItems() - 1, editTheTitleTo);
        return this;
    }


    public Integer getCountInFooter() {
        return structure.getCountInFooter();
    }

    public String getCountTextInFooter() {
        return structure.getCountTextInFooter();
    }

    public ApplicationPageFunctionalFluent filterOnAll() {
        structure.clickOnFilter(StructuralEnums.Filter.ALL);
        return this;
    }

    public ApplicationPageFunctionalFluent filterOnActive() {
        structure.clickOnFilter(StructuralEnums.Filter.ACTIVE);
        return this;
    }

    public ApplicationPageFunctionalFluent filterOnCompleted() {
        structure.clickOnFilter(StructuralEnums.Filter.COMPLETED);
        return this;
    }

    public ApplicationPageFunctionalFluent toggleCompletionOfLastItem() {
        structure.toggleCompletionOfItem(getCountOfTodoDoItems() - 1);
        return this;
    }

    public boolean isClearCompletedVisible() {
        return structure.isClearCompletedVisible();
    }

    public Integer getClearCompletedCount() {
        return structure.getClearCompletedCount();
    }

    public ApplicationPageFunctionalFluent clearCompleted() {
        structure.clickClearCompleted();
        return this;
    }

    public ApplicationPageFunctionalFluent and(){
        return this;
    }

    public ApplicationPageFunctionalFluent then(){
        return this;
    }

    public ApplicationPageFunctionalFluent also(){
        return this;
    }
}
