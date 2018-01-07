package advanced.pageobjects.pages.todomvc;


import advanced.pageobjects.pages.StructuralEnums;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;




public class ApplicationPageFunctional {


    private ApplicationPageStructural structure;


    public ApplicationPageFunctional(WebDriver driver) {

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

    public void enterNewToDo(String todoTitle) {
        // could be Keys.ENTER on 2.40.0 and below
        // but needs to be Keys.RETURN on 2.41.0
        structure.typeIntoNewToDo(todoTitle, Keys.RETURN);
    }

    public void get() {
        structure.get();
    }

    public boolean isFooterVisible() {
        // catch any not found exceptions at functional layer
        try{
            return structure.isFooterVisible();
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public boolean isMainVisible() {
        try{
            return structure.isMainVisible();
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public void deleteLastToDo() {
        structure.deleteTodoItem(getCountOfTodoDoItems()-1);
    }


    public void editLastItem(String editTheTitleTo) {
        structure.editItem(getCountOfTodoDoItems()-1,editTheTitleTo);
    }


    public Integer getCountInFooter() {
        try{
            return structure.getCountInFooter();
        }catch(NoSuchElementException e){
            return 0;
        }
    }

    public String getCountTextInFooter() {

        String countText = "";
        try{
            countText = structure.getCountTextInFooter();
        }catch(NoSuchElementException e){

        }

        return countText;
    }

    public void filterOnAll() {
        structure.clickOnFilter(StructuralEnums.Filter.ALL);
    }

    public void filterOnActive() {
        structure.clickOnFilter(StructuralEnums.Filter.ACTIVE);
    }

    public void filterOnCompleted() {
        structure.clickOnFilter(StructuralEnums.Filter.COMPLETED);
    }

    public void toggleCompletionOfLastItem() {
        structure.toggleCompletionOfItem(getCountOfTodoDoItems() - 1);
    }

    public boolean isClearCompletedVisible() {
        return structure.isClearCompletedVisible();
    }

    public Integer getClearCompletedCount() {

        return structure.getClearCompletedCount();
    }

    public void clearCompleted() {
        structure.clickClearCompleted();
    }
}