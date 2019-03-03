package rest_assured;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LikeRestTest {

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
    public void getAllLikesOfMessage() {
        given().when().get("/api/like/1").then().statusCode(200);
    }

    @Test
    public void getAccountsLiked() {
        given().when().get("/api/like/account/1").then().statusCode(200);
    }
}
