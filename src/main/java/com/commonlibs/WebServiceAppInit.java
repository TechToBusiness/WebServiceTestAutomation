package com.commonlibs;

import com.config.PathVariables;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class WebServiceAppInit {
    static PathVariables objPV = PathVariables.getPathVariableObject();

    public static void startAppJar() throws IOException {
        String tempPath = System.getProperty("appJARLocation") + System.getProperty("jarName");

        String path = Thread.currentThread().getContextClassLoader().getResource(tempPath).getPath().toString();
        String  path1 = (new File(path)).getAbsolutePath();
        Process p =  Runtime.getRuntime().exec("cmd.exe /c java -jar " + path1);
    }

    public static void shutdownAppJar() throws IOException {
        RestAssured.baseURI = System.getProperty("appURL");
//        RequestSpecification request  = RestAssured.given();
//        Response response =  request.request(Method.GET, "/shutdown");
//        RestAssured.get("/todos");

    }


}
