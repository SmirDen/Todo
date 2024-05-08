package com.todo.resource;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@QuarkusTest
public class UserResourceTest {

    private Long addedUserId;

    @Test
    public void testGetAllUsers() {
        given()
                .when().get("/users")
                .then()
                .statusCode(200);
    }

    @Test
    public void testAddUser() {
        given()
                .body("{\"username\": \"usernameTest\", \"password\": \"passwordTest\", \"email\": \"test@example.com\"}")
                .contentType(ContentType.JSON)
                .when().post("/users")
                .then()
                .statusCode(204)
                .extract().response().asString();

        addedUserId = Long.parseLong(given()
                .when().get("/users")
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("id").get(0).toString());
        System.out.println("User id = " + addedUserId);
    }

    @Test
    public void testGetUserById() {
        System.out.println("User id = " + addedUserId);
        if (addedUserId == null) {
            System.out.println("addedUserId is null");
            return;
        }

        given()
                .pathParam("id", addedUserId)
                .when().get("/users/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(addedUserId.intValue()));
    }

    @Test
    public void testUpdateUser() {
        System.out.println("User id = " + addedUserId);
        if (addedUserId == null) {
            System.out.println("addedUserId is null");
            return;
        }
        given()
                .pathParam("id", addedUserId)
                .body("{\"username\": \"updated\", \"password\": \"updated\", \"email\": \"updated@example.com\"}")
                .contentType(ContentType.JSON)
                .when().put("/users/{id}")
                .then()
                .statusCode(204);
    }

    @Test
    public void testDeleteUser() {
        System.out.println("User id = " + addedUserId);
        if (addedUserId == null) {
            System.out.println("addedUserId is null");
            return;
        }

        given()
                .pathParam("id", addedUserId)
                .when().delete("/users/{id}")
                .then()
                .statusCode(204);
    }
}
