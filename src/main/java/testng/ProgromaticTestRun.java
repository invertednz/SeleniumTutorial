package testng;

import java.util.Arrays;
import org.testng.TestNG;
import org.testng.xml.*;

public class ProgromaticTestRun {

    static TestNG testng;

    public static void main(String[] args) {

        try {
            testng = new TestNG();
            testng.setPreserveOrder(true);
            testng.setVerbose(2);

            // create a suite programmatically
            XmlSuite suite = new XmlSuite();
            suite.setName("Programmatic XmlSuite");

            // create a test case for the suite
            XmlTest xmltest = new XmlTest(suite);
            xmltest.setName("Test1");
            xmltest.setXmlClasses(Arrays.asList(new XmlClass("testng.SampleTest")));

            // add a suite-file to the suite
            suite.setSuiteFiles(Arrays.asList("c:\\webdriver\\suite1.xml"));

            // 1. To run with testng.xml file, uncomment this one, comment 2
            // testng.setTestSuites(Arrays.asList("testng.xml"));

            // 2. to run with XmlSuite, uncomment this one, comment 1
            testng.setXmlSuites(Arrays.asList(suite));

            testng.run();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }
}