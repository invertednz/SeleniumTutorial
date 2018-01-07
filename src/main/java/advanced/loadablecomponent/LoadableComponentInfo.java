package advanced.loadablecomponent;

/**
 * Created by jfarrier on 5/12/2016.
 *
 * The LoadableComponent is a base class that aims to make writing PageObjects less painful. It does this by providing a standard way of ensuring
 * that pages are loaded and providing hooks to make debugging the failure of a page to load easier. You can use it to help reduce the amount of
 * boilerplate code in your tests, which in turn make maintaining your tests less tiresome.
 * There is currently an implementation in Java that ships as part of Selenium 2, but the approach used is simple enough to be implemented in any language.
 *
 * The load method is used to navigate to the page, whilst the isLoaded method is used to determine whether we are on the right page. Although the method
 * looks like it should return a boolean, instead it performs a series of assertions using JUnit's Assert class. There can be as few or as many assertions
 * as you like. By using these assertions it's possible to give users of the class clear information that can be used to debug tests.
 *
 * The Example included is from - https://github.com/sargissargsyan/page-objects-loadable-component
 *
 * SeleniumHQ Page - https://github.com/SeleniumHQ/selenium/wiki/LoadableComponent
 *
 */
public class LoadableComponentInfo {
}
