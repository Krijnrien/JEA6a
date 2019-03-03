package rest_assured;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RoleRestTest {

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
    public void getAllRoles() {
        given().when().get("/api/role").then().statusCode(200);
    }

    @Test
    public void getAccountsWithRole() {
        given().when().get("/api/role/user").then().statusCode(200);
    }
}
