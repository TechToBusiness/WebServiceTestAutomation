package com.commonlibs;

import com.config.PathVariables;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.HashMap;

public class SuiteLevelSteps {
    static PathVariables objPV = PathVariables.getPathVariableObject();


    @BeforeSuite (alwaysRun = true)
    public void startApp() throws IOException {
        objPV.getProperties();
        if (System.getProperty("appType").equals("jar"))
            WebServiceAppInit.startAppJar();
    }

    @AfterSuite (alwaysRun = false)
    public void shutdownApp() throws IOException {
        if (System.getProperty("appType").equals("jar"))
            WebServiceAppInit.shutdownAppJar();
    }
}
