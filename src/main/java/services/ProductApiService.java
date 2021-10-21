package services;

import constants.Url;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.ProductModel;

import static io.restassured.RestAssured.given;

public class ProductApiService {

    public static Response getAllProducts(RequestSpecification requestSpec) {

        return given().log().all()
                .spec(requestSpec)
                .when()
                .get(Url.PRODUCT_SERVICES_URL + "/product")
                .then()
                .extract().response();

    }

    public static Response createProduct(RequestSpecification requestSpec, ProductModel productModel) {

        return given().log().all()
                .spec(requestSpec)
                .body(productModel)
                .when()
                .post(Url.PRODUCT_SERVICES_URL + "/product")
                .then()
                .extract().response();

    }

    public static Response getProductById(RequestSpecification requestSpec, String id) {

        return given().log().all()
                .spec(requestSpec)
                .when()
                .get(Url.PRODUCT_SERVICES_URL + "/product/" + id)
                .then()
                .extract().response();

    }

    public static Response updateProduct(RequestSpecification requestSpec, ProductModel productModel, String id) {

        return given().log().all()
                .spec(requestSpec)
                .body(productModel)
                .when()
                .put(Url.PRODUCT_SERVICES_URL + "/product/" + id)
                .then()
                .extract().response();

    }

    public static Response deleteProduct(RequestSpecification requestSpec, String id) {

        return given().log().all()
                .spec(requestSpec)
                .when()
                .delete(Url.PRODUCT_SERVICES_URL + "/product/" + id)
                .then()
                .extract().response();

    }

}
