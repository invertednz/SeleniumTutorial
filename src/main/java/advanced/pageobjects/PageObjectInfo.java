package advanced.pageobjects;

/**
 * Created by jfarrier on 7/12/2016.
 *
 * What is a Page Object
 *
 * A Page Object is a form of abstraction.
 * A Page Object is a representation of the physical page in code.
 * It includes all of the elements and common interactions that can occur on the page.
 *
 * Why Page Objects?
 *
 * Tests become shorter more readable.
 * Changes are isolated to the page which changed, rather than spread across tests.
 * Tests start to follow better coding standards, specifically one responsibility and DRY.
 *
 * Additional Information
 *
 * A Page Object can be further abstracted to include specific components, such as a menu bar.
 * Your other Page Objects may contain this Page Object.
 *
 * What should your Page Object contain
 *
 * Which elements to expose?
 * Which elements to group into sub-components?
 *
 * How should our actions look?
 * login(username, password), login(user), validLogin(user), invalidLogin(username, password)
 * enterName(username
 *
 * Page Object return
 *
 * Page Factory
 * - annotated elements, lazy instantiation via reflection.
 *
 * Basic pageobject - https://github.com/eviltester/automationAbstractions/blob/master/src/main/java/com/seleniumsimplified/todomvc/page/pojo/ApplicationPage.java
 *
 * Benefits of functional vs structural
 * loginas vs enterUsername then enterPassword etc.
 * Structural vs functional
 * https://github.com/eviltester/automationAbstractions/tree/master/src/main/java/com/seleniumsimplified/todomvc/page/functionalvsstructural
 *
 * Page Factory
 * https://github.com/eviltester/automationAbstractions/blob/master/src/main/java/com/seleniumsimplified/todomvc/page/pagefactory/ApplicationPageStructuralFactory.java
 *
 * Pros/Cons
 * Make your own init
 *
 * The examples are tweaked from https://github.com/eviltester/automationAbstractions/
 *
 * Levels of Abstraction -
 * PageObject - page.addTodo
 * User - user.addTodo
 * Website - website.addTodo
 *
 *
 * Exercise - abstract out the url such that it is easier to change when running in different environments
 *
 */
public class PageObjectInfo {
}
