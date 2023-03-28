package com.stepDefinitions;

import com.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class PetStatusCheck {
    Response response;

    String baseUrl = ConfigurationReader.get("baseUrl");
    Map<String, Object> queryMap = new HashMap<>();

    @DisplayName("available")
    @Test
    public void PetStatusAvailable() {
        baseUrl = ConfigurationReader.get("baseUrl");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("status", "available");

        Response response = given().log().all().
                accept(ContentType.JSON).
                and().
                queryParams(queryMap).
                when().
                get(baseUrl + "/pet/findByStatus");

        //check if response is 200
        Assert.assertEquals(200, response.statusCode());
        System.out.println("response.statusCode() = " + response.statusCode());
        //check if the response type is json
        Assert.assertEquals("application/json", response.contentType());
        //check the response type of the "Transfer-Encoding" is "chunked"
        Assert.assertEquals("chunked", response.header("Transfer-Encoding"));
        //check the response type of the "Connection" is "keep-alive"
        Assert.assertEquals("keep-alive", response.header("Connection"));
        //check if date appeared as header
        response.headers().hasHeaderWithName("date");

        response.prettyPrint();
    }

    @DisplayName("Pending")
    @Test
    public void PetStatusPending() {
        baseUrl = ConfigurationReader.get("baseUrl");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("status", "pending");

        Response response = given().log().all().
                accept(ContentType.JSON).
                and().
                queryParams(queryMap).
                when().
                get(baseUrl + "/pet/findByStatus");

        Assert.assertEquals(200, response.statusCode());
        System.out.println("response.statusCode() = " + response.statusCode());
        //check if the response type is json
        Assert.assertEquals("application/json", response.contentType());
        //check the response type of the "Transfer-Encoding" is "chunked"
        Assert.assertEquals("chunked", response.header("Transfer-Encoding"));
        //check the response type of the "Connection" is "keep-alive"
        Assert.assertEquals("keep-alive", response.header("Connection"));
        //check if date appeared as header
        response.headers().hasHeaderWithName("date");

        response.prettyPrint();
    }

    @DisplayName("sold")
    @Test
    public void PetStatusSold() {
        baseUrl = ConfigurationReader.get("baseUrl");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("status", "sold");

        Response response = given().log().all().
                accept(ContentType.JSON).
                and().
                queryParams(queryMap).
                when().
                get(baseUrl + "/pet/findByStatus");

        Assert.assertEquals(200, response.statusCode());
        System.out.println("response.statusCode() = " + response.statusCode());
        //check if the response type is json
        Assert.assertEquals("application/json", response.contentType());
        //check the response type of the "Transfer-Encoding" is "chunked"
        Assert.assertEquals("chunked", response.header("Transfer-Encoding"));
        //check the response type of the "Connection" is "keep-alive"
        Assert.assertEquals("keep-alive", response.header("Connection"));
        //check if date appeared as header
        response.headers().hasHeaderWithName("date");

        response.prettyPrint();
    }
}