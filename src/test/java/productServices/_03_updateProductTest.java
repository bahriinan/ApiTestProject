package productServices;

import constants.CustomRequestSpec;
import constants.TestData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.ProductModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.ProductApiService;

import static helper.AssertionHelper.assertStatusCode;
import static helper.AssertionHelper.assertString;

public class _03_updateProductTest {

    private static RequestSpecification requestSpec;

    @BeforeClass
    public void setUp(){

        requestSpec = new CustomRequestSpec.Builder().build();

    }

    @Test
    public void updateProduct_whenAllFieldsAreValid_shouldReturnSuccess() {

        ProductModel productModel = new ProductModel.Builder().build();
        Response createResponse = ProductApiService.createProduct(requestSpec, productModel);
        assertStatusCode(createResponse, 200);
        ProductModel updateProductModel = new ProductModel.Builder().setId(TestData.updatedId).setName(TestData.updatedName).setDescription(TestData.updatedDescription).build();
        Response updateResponse = ProductApiService.updateProduct(requestSpec, updateProductModel, TestData.id);
        assertStatusCode(updateResponse, 200);
        assertString(updateResponse, "id", TestData.updatedId);
        assertString(updateResponse, "name", TestData.updatedName);
        assertString(updateResponse, "description", TestData.updatedDescription);

    }

    @Test
    public void updateProduct_whenIdIsNotRegistered_shouldReturnNotFound() {// should return not found

        ProductModel productModel = new ProductModel.Builder().build();
        Response createResponse = ProductApiService.createProduct(requestSpec, productModel);
        assertStatusCode(createResponse, 200);
        ProductModel updateProductModel = new ProductModel.Builder().setId(TestData.updatedId).setName(TestData.updatedName).setDescription(TestData.updatedDescription).build();
        Response updateResponse = ProductApiService.updateProduct(requestSpec, updateProductModel, "1242342342342334");
        assertStatusCode(updateResponse, 404);

    }

    @Test
    public void updateProduct_whenAllFieldsAreNull_shouldReturnBadRequest() {

        ProductModel productModel = new ProductModel.Builder().build();
        Response createResponse = ProductApiService.createProduct(requestSpec, productModel);
        assertStatusCode(createResponse, 200);
        ProductModel updateProductModel = new ProductModel.Builder().setId(null).setName(null).setDescription(null).build();
        Response updateResponse = ProductApiService.updateProduct(requestSpec, updateProductModel, TestData.id);
        assertStatusCode(updateResponse, 400);

    }

}
