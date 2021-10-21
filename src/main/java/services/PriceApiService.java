package services;

import constants.Url;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PriceApiService {

    public static Response getPrice(RequestSpecification requestSpec, String id) {

        return given().log().all()
                .spec(requestSpec)
                .when()
                .get(Url.PRICE_ENGINE_URL + "/product/" + id)
                .then()
                .extract().response();

    }

}
