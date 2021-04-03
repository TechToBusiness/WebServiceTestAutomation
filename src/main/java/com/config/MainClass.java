package com.config;

import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

public class MainClass {

    public static void main(String[] args){
        // Get the path to testng.xml
        String xmlPath = System.getProperty("user.dir") + "/testng.xml";

        // Run all the tests in testng.xml
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add(xmlPath);
        testng.setTestSuites(suites);
        testng.run();
    }
}