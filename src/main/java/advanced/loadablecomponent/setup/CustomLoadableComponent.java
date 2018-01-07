package advanced.loadablecomponent.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static advanced.loadablecomponent.setup.SeleniumDriver.getDriver;

/**
 * Custom Loadable Component
 *
 * Created by sargis on 4/3/16.
 *
 * Further info at https://confengine.com/selenium-conf-2016/proposal/2340/better-page-object-handling-with-loadable-component-pattern
 * https://github.com/eviltester/webDriverExperiments/tree/master/src/test/java/com/seleniumsimplified/webdriver/slowloading
 * http://seleniumsimplified.com/2013/08/helper-classes-for-slowloadablecomponent-page-objects/
 * http://seleniumsimplified.com/2013/07/slowloadablecomponent-and-nosuchelementexception/
 * https://github.com/eviltester/automationAbstractions/tree/master/src/main/java/com/seleniumsimplified/selenium/support/navigation
 *
 * Selenium Implementation:
 * https://github.com/SeleniumHQ/selenium/blob/master/java/client/src/org/openqa/selenium/support/ui/SlowLoadableComponent.java
 */
public abstract class CustomLoadableComponent<T extends CustomLoadableComponent<T>> {
    private WebDriver driver;

    private static final int LOAD_TIMEOUT = 5;
    private static final int REFRESH_RATE = 2;
    SystemClock clock;

    @SuppressWarnings("unchecked")
    public T get() {
        try {
            isLoaded();
            return (T) this;
        } catch (Error e) {
            // This is the extra line of code
            System.out.println("Error encountered during page load: " + e.getMessage());
            load();
        }
        //SlowLoadable
        /*long end = clock.laterBy((TimeUnit.MILLISECONDS.toMillis(LOAD_TIMEOUT)));
        while(clock.isNowBefore(end)){
            try {
                isLoaded();
                return (T) this;
            }
            catch (Error e){

            }

            //isError();

            waitFor();
        }*/

        isLoaded();

        return (T) this;
    }

    protected abstract void load();

    protected abstract void isLoaded() throws Error;

    protected void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
        Wait wait = new FluentWait(getDriver())
                .withTimeout(LOAD_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(REFRESH_RATE, TimeUnit.SECONDS);

        wait.until(pageLoadCondition);
    }

    protected long sleepFor(){
        return 200;
    }

    /*
    private void waitFor(){

        try{
            Thread.sleep(sleepFor());
        } catch (InterruptedException e){
            fail(e.getMessage());
        }
    }
    */
}
