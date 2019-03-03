package rest_assured;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class KwetRestTest {

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
    public void getAllMessages() {
        given().when().get("/api/message").then().statusCode(200);
    }

    @Test
    public void getAllMessagesOfUser() {
        given().when().get("/api/message/Violet").then().statusCode(200);
    }

    @Test
    public void getMessageWithWord() {
        given().when().get("/api/message/first").then()
                .body(containsString(""));
    }
}
