package testng;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class ProgramTestRun {
    public void testNgXmlSuite() {

        List<XmlSuite>suites = new ArrayList<XmlSuite>();
        List<XmlClass>classes = new ArrayList<XmlClass>();
        List<Class>listenerClasses = new ArrayList<Class>();

        XmlSuite suite = new XmlSuite();
        suite.setName("ProgramSuite");

        XmlTest test = new XmlTest(suite);
        test.setName("ProgramTest");

        XmlClass clss1 = new XmlClass("testng.SampleProgramOne");
        classes.add(clss1);

        XmlClass clss2 = new XmlClass("testng.SampleProgramTwo");
        classes.add(clss2);

        listenerClasses.add(ListenerTest.class);

        test.setXmlClasses(classes);

        suites.add(suite);

        TestNG tng = new TestNG();

        tng.setXmlSuites(suites);
        //tng.setTestNames();
        tng.setListenerClasses(listenerClasses);
        tng.run();
    }

    public static void main(String[] args) {
        ProgramTestRun testRun = new ProgramTestRun();
        testRun.testNgXmlSuite();
    }
}