package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTests {

    protected RequestSpecification request;

    @BeforeEach
    public void setUp() {
        request = RestAssured.given().spec(createRequestSpec());
    }

    @AfterEach
    public void tearDown() {
    }

    private RequestSpecification createRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .addFilter(new RequestFilter())
                .addHeader("x-api-key", "reqres-free-v1")
                .setContentType(ContentType.JSON)
                .build();
    }
}