package productServices;

import constants.CustomRequestSpec;
import constants.TestData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.ProductApiService;

import static helper.AssertionHelper.*;

public class _02_getProductByIdTest {

    private static RequestSpecification requestSpec;

    @BeforeClass
    public void setUp(){

        requestSpec = new CustomRequestSpec.Builder().build();

    }

    @Test
    public void getUserById_whenIdIsRegistered_shouldReturnSuccess() {

        Response getResponse = ProductApiService.getProductById(requestSpec, TestData.id);
        getResponse.prettyPrint();
        assertStatusCode(getResponse, 200);
        assertString(getResponse, "name", TestData.name);
        assertString(getResponse, "description", TestData.description);

    }

    @Test
    public void getUserById_whenIdIsNotRegistered_shouldReturnNotFound() {// If id is not valid should return not found

        Response getResponse = ProductApiService.getProductById(requestSpec, "1234234235");
        getResponse.prettyPrint();
        assertStatusCode(getResponse, 404);

    }


}
