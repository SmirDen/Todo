package com.todo.resource;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class UserResourceTest {

    @Test
    public void testGetAllUsers() {
        given()
                .when().get("/users")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetUserById() {
        given()
                .pathParam("id", 1)
                .when().get("/users/{id}")
                .then()
                .statusCode(200)
                .body("userId", equalTo(1));
    }

    @Test
    public void testAddUser() {
        given()
                .body("{\"username\": \"test\", \"passwordHash\": \"password\", \"email\": \"test@example.com\"}")
                .contentType(ContentType.JSON)
                .when().post("/users")
                .then()
                .statusCode(204);
    }

    @Test
    public void testUpdateUser() {
        given()
                .pathParam("id", 1)
                .body("{\"username\": \"updated\", \"passwordHash\": \"updated\", \"email\": \"updated@example.com\"}")
                .contentType(ContentType.JSON)
                .when().put("/users/{id}")
                .then()
                .statusCode(204);
    }

    @Test
    public void testDeleteUser() {
        given()
                .pathParam("id", 1)
                .when().delete("/users/{id}")
                .then()
                .statusCode(204);
    }
}
