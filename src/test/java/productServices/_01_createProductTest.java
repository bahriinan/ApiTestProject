package productServices;

import constants.CustomRequestSpec;
import constants.TestData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.ProductModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.ProductApiService;

import static helper.AssertionHelper.*;


public class _01_createProductTest {

    private static RequestSpecification requestSpec;

    @BeforeClass
    public void setUp(){

        requestSpec = new CustomRequestSpec.Builder().build();

    }

    @Test
    public void createProduct_whenAllFieldsAreValid_shouldCreateProduct() {

        ProductModel productModel = new ProductModel.Builder().build();
        Response createResponse = ProductApiService.createProduct(requestSpec, productModel);
        createResponse.prettyPrint();
        assertStatusCode(createResponse, 200);
        assertString(createResponse, "id", TestData.id);
        assertString(createResponse, "name", TestData.name);
        assertString(createResponse, "description", TestData.description);

    }

    @Test
    public void createProduct_whenIdIsNotUnique_shouldReturnBadRequest() {// id should be unique

        ProductModel productModel = new ProductModel.Builder().build();
        Response createResponse = ProductApiService.createProduct(requestSpec, productModel);
        createResponse.prettyPrint();
        assertStatusCode(createResponse, 200);
        ProductModel productModelAgain = new ProductModel.Builder().build();
        Response createNewResponse = ProductApiService.createProduct(requestSpec, productModelAgain);
        createNewResponse.prettyPrint();
        assertStatusCode(createResponse, 400);
        //TODO: message will be add


    }

    @Test
    public void createProduct_whenIdFieldIsNull_shouldReturnBadRequest() {//id field should not be empty

        ProductModel productModel = new ProductModel.Builder().setId(null).build();
        Response createResponse = ProductApiService.createProduct(requestSpec, productModel);
        createResponse.prettyPrint();
        assertStatusCode(createResponse, 400);
        //TODO: message will be add

    }

    @Test
    public void createProduct_whenNameFieldIsNull_shouldReturnBadRequest() {//name field should not be empty

        ProductModel productModel = new ProductModel.Builder().setName(null).build();
        Response createResponse = ProductApiService.createProduct(requestSpec, productModel);
        createResponse.prettyPrint();
        assertStatusCode(createResponse, 400);
        //TODO: message will be add

    }

    @Test
    public void createProduct_whenDescriptionFieldIsNull_shouldReturnBadRequest() {//description field should not be empty

        ProductModel productModel = new ProductModel.Builder().setDescription(null).build();
        Response createResponse = ProductApiService.createProduct(requestSpec, productModel);
        createResponse.prettyPrint();
        assertStatusCode(createResponse, 400);
        //TODO: message will be add

    }


}
