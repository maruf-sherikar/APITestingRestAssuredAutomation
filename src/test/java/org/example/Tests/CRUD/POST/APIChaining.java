package org.example.Tests.CRUD.POST;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;

public class APIChaining {


    @Test
    public void apiChainingTC(){

        String payload = "";
        String updatePayload = "";


        Response response =
                         given()
                        .body(payload)
                        .when()
                        .post("/users");

        String userId = response.jsonPath().getString("id");

        given()
                .pathParam("id", userId)
                .body(updatePayload)
                .when()
                .put("/users/{id}");
    }
}
