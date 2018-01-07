package testng;

/**
 * Created by james on 11/06/2017.
 *
 * To run testNG from an existing java framework you can create an XML file or
 * you can do the following
 *
 * http://www.automatedsqa.com/2012/08/running-testng-programmatically-example.html
 */

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class XML {
    public static void main(String[] args){
            List<String> file = new ArrayList<String>();
            file.add("c:/webdriver/suite1.xml");
            TestNG testNG = new TestNG();
            testNG.setTestSuites(file);
            testNG.run();
    }
}
