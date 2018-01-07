package advanced.loadablecomponent.setup;

import org.testng.annotations.AfterClass;
import static advanced.loadablecomponent.setup.SeleniumDriver.getDriver;


/**
 * SeleniumBaseTest
 *
 * Created by Sargis on 4/3/16.
 */
public class SeleniumBaseTest {
    @AfterClass
    public static void tearDown() {
        getDriver().close();
    }
}