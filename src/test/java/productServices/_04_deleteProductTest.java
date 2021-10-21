package productServices;

import constants.CustomRequestSpec;
import constants.TestData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.ProductApiService;

import static helper.AssertionHelper.*;

public class _04_deleteProductTest {

    private static RequestSpecification requestSpec;

    @BeforeClass
    public void setUp(){

        requestSpec = new CustomRequestSpec.Builder().build();

    }

    @Test
    public void deleteProduct_whenIdIsRegistered_shouldReturnSuccess() {

        Response deleteResponse = ProductApiService.deleteProduct(requestSpec, TestData.id);
        deleteResponse.prettyPrint();
        assertStatusCode(deleteResponse, 200);

    }

    @Test
    public void deleteProduct_whenIdIsNotRegistered_shouldReturnNotFound() {

        Response deleteResponse = ProductApiService.deleteProduct(requestSpec, "435345345");
        deleteResponse.prettyPrint();
        assertStatusCode(deleteResponse, 404);

    }

    @Test
    public void deleteProduct_whenIdIsTryingTheDeleteTwice_shouldReturnNotFoundInTwice() {

        Response deleteResponse = ProductApiService.deleteProduct(requestSpec, TestData.updatedId);
        deleteResponse.prettyPrint();
        assertStatusCode(deleteResponse, 200);
        Response deleteResponseTwice = ProductApiService.deleteProduct(requestSpec, TestData.updatedId);
        deleteResponseTwice.prettyPrint();
        assertStatusCode(deleteResponseTwice, 404);

    }

}
