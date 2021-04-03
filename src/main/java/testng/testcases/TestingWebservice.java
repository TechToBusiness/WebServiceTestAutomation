package testng.testcases;

import com.config.PathVariables;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;


public class TestingWebservice {
    PathVariables objPV = PathVariables.getPathVariableObject();

    @BeforeClass
    public void beforeClass() throws Exception {

    }

    @Test (groups = {"test1", "test2"}, priority = 2)
    public void getChallenges() {
        RequestSpecification request  = RestAssured.given()
                .header("Accept", "application/json")
                .header("X-CHALLENGER", System.getProperty("X-CHALLENGER"));
        Response r = request.get(System.getProperty("appURL") + "/challenges");
        String id = r.jsonPath().getString("todos");
        List jSONResponse = r.jsonPath().getList("challenges");

        for(int i = 0; i < jSONResponse.size(); i++)
        {
            System.out.println(jSONResponse.get(i));

        }

        System.out.println("Size of JSON Response is " + jSONResponse.size());
        ResponseBody rb = r.getBody();
        String b = rb.asString();

    }

    @Test (groups = {"test1", "test2"}, priority = 1)
    public void getChallengerKey() {
        RequestSpecification request = RestAssured.given();

        Response r = request.post(System.getProperty("appURL") + "/challenger");

        String challengerKey = r.header("X-CHALLENGER").toString();
        Assert.assertNotNull(challengerKey);
            System.setProperty("X-CHALLENGER", challengerKey);

    }

    @Test (groups = {"test1", "test2"}, priority = 2, alwaysRun = false)
    public void getTODOS() {
        RequestSpecification request = RestAssured.given()
                .header("Accept", "application/json")
                .header("X-CHALLENGER", System.getProperty("X-CHALLENGER"));

        Response r = request.get(System.getProperty("appURL") + "/todos");
        String id = r.jsonPath().getString("todos");
//        r.jsonPath().get()
    }



}
