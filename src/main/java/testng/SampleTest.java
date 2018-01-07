package testng;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest {
    ITestContext context;

    @BeforeMethod
    public void setup(ITestContext context) {
        this.context = context;
    }

    @Test
    public void test1() {
        System.out.println("Now Running: " + context.getSuite().getName()
                + ", SampleTest");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}