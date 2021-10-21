package helper;

import io.restassured.response.Response;
import org.testng.Assert;

public class AssertionHelper {

    public static void assertString(Response response, String path, String expected) {


        Assert.assertEquals(response.getBody().jsonPath().getString(path), expected);
    }

    public static void assertInt(Response response, String path, int expected) {


        Assert.assertEquals(response.getBody().jsonPath().getInt(path), expected);
    }

    public static void assertBoolean(Response response, String path, boolean expected) {


        Assert.assertEquals(response.getBody().jsonPath().getBoolean(path), expected);
    }

    public static void assertNull(Response response, String path) {

        Assert.assertNull(response.getBody().jsonPath().getString(path));
    }

    public static void assertStatusCode(Response response, int statusCode) {

        Assert.assertEquals(response.getStatusCode(), statusCode);

    }
}
