package priceServices;

import constants.CustomRequestSpec;
import constants.TestData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.PriceApiService;

import static helper.AssertionHelper.assertStatusCode;

public class _01_getPriceTests {

    private static RequestSpecification requestSpec;

    @Test
    public void getPrice_whenIdAndLanguageIsValid_shouldReturnSuccess() {

        requestSpec = new CustomRequestSpec.Builder().withAcceptLanguage("en-EN").priceBuild();
        Response getResponse = PriceApiService.getPrice(requestSpec, TestData.updatedId);
        getResponse.prettyPrint();
        assertStatusCode(getResponse, 200);

    }

    @Test
    public void getPrice_whenIdIsNotRegistered_shouldReturnNotFound() {

        requestSpec = new CustomRequestSpec.Builder().withAcceptLanguage("en-EN").priceBuild();
        Response getResponse = PriceApiService.getPrice(requestSpec, "324234234234");
        getResponse.prettyPrint();
        assertStatusCode(getResponse, 404);

    }

    @Test
    public void getPrice_whenAcceptLanguageIsNotValid_shouldReturnBadRequest() {

        requestSpec = new CustomRequestSpec.Builder().withAcceptLanguage("testtest").priceBuild();
        Response getResponse = PriceApiService.getPrice(requestSpec, TestData.updatedId);
        getResponse.prettyPrint();
        assertStatusCode(getResponse, 400);

    }

}
