package rest_assured;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class AccountRestTest {

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "/JEA_Kwetter/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://localhost";
        }
        baseURI = baseHost;
    }


    @Test
    public void getAllAccounts() {
        given().when().get("/api/account").then().statusCode(200);
    }

    @Test
    public void typoInUserName() {
        given().when().get("/api/account/Vamana")
                .then().statusCode(500);
    }

    @Test
    public void verifyNameStructured() {
        given().when().get("/api/account/Swagger").then()
                .body("username", equalTo("Swagger"));
    }

    @Test
    public void getAllFollowersOfAccount() {
        given().when().get("/api/account/followers/Swagger").then()
                .body("username", equalTo("Vamana"));
    }

    @Test
    public void getAllFollowingsOfAccount() {
        given().when().get("/api/account/followings/Swagger").then()
                .body("username", equalTo("Vamana"));
    }
}