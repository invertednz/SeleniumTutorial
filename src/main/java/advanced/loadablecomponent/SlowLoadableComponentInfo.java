package advanced.loadablecomponent;

/**
 * Created by jfarrier on 6/12/2016.
 *
 * The SlowLoadableComponent is a support class in WebDriver which provides a simple and consistent way of writing PageObjects which model
 * pages and components that take additional time from being present in the DOM to being ready to use.

 A SlowLoadableComponent has a public ‘get’ method that it inherits from SlowLoadableComponent, and 2 additional methods a ‘load’ and an
 ‘isLoaded’ method. When the ‘get’ method is called, the ‘isLoaded’ method is used to check if the component is loaded, if not then the ‘load’
 method is called, and then the SlowLoadableComponent polls the ‘isLoaded’ method until the component is loaded or a timeout time is exceeded.

 The SlowLoadableComponent also has a isError method to check for well known error cases, which would mean that the loading has finished but
 an error condition was seen and a waitFor method.
 */
public class SlowLoadableComponentInfo {
}
