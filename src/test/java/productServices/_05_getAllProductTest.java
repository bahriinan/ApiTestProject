package productServices;

import constants.CustomRequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.ProductApiService;

import static helper.AssertionHelper.*;

public class _05_getAllProductTest {

    private static RequestSpecification requestSpec;

    @BeforeClass
    public void setUp(){

        requestSpec = new CustomRequestSpec.Builder().build();

    }

    @Test
    public void getAllProduct_whenTableIsNotEmpty_shouldReturnRegisteredProducts() {

        Response getResponse = ProductApiService.getAllProducts(requestSpec);
        getResponse.prettyPrint();
        assertStatusCode(getResponse, 200);

    }


}
