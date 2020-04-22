package com.epam;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import static java.util.Collections.singletonList;

public class Runner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();

        XmlSuite suite = new XmlSuite();
        suite.setSuiteFiles(singletonList("./src/test/resources/testng.xml"));

        testNG.setXmlSuites(singletonList(suite));

        testNG.run();
    }
}
