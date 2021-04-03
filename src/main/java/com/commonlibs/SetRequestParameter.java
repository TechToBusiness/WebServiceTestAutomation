package com.commonlibs;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class SetRequestParameter {
    private static SetRequestParameter objSRP;
    private SetRequestParameter() {

    }
    public static RequestSpecification ReturnRequest(){
        RequestSpecification request;
        request = RestAssured.given();
        return request;
    }

    public static SetRequestParameter getRequestParameter(){
        if(objSRP == null)
            objSRP = new SetRequestParameter();

        return objSRP;
    }

    public static Response ReturnResponse(RequestSpecification request ,String endURL){
        Response response;
        response = request.get(endURL);

        return response;
    }


    public static Response ReturnResponse(RequestSpecification request ,String endURL, String Body){
        Response response;
        response = request.get(endURL);

        return response;
    }
}
