package constants;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class CustomRequestSpec {

    public static final String HEADER_SUBJECT = "Content-type";
    public static final String HEADER_OBJECT = "application/json;charset=UTF-8";

    public static RequestSpecBuilder builder = new RequestSpecBuilder();
    public static RequestSpecification requestSpec;

    public static class Builder {

        private static String XACCEPTLANGUAGE = "Accept-Language";
        private static String ACCEPTLANGUAGE;
        public Builder withAcceptLanguage(String language) {

            this.ACCEPTLANGUAGE = language;
            return this;

        }

        public RequestSpecification build() {

            builder.addHeader(HEADER_SUBJECT, HEADER_OBJECT);
            requestSpec = builder.build();
            builder = new RequestSpecBuilder();
            return requestSpec;

        }

        public RequestSpecification priceBuild() {

            builder.addHeader(HEADER_SUBJECT, HEADER_OBJECT);
            builder.addHeader(XACCEPTLANGUAGE, ACCEPTLANGUAGE);
            requestSpec = builder.build();
            builder = new RequestSpecBuilder();
            return requestSpec;

        }

    }
}