package api.users;

import api.BaseAPI;
import io.restassured.builder.RequestSpecBuilder;

import static io.restassured.RestAssured.given;

public class Users extends BaseAPI {

    String token;
    String apiPath = "/api/v1/users/";
    String phoneNumber;

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Users(String baseURI, String token) {
        super(baseURI);
        this.token = token;
    }

    private RequestSpecBuilder addQueryParam(RequestSpecBuilder requestSpecBuilder) {
        if (this.phoneNumber != null) {
            requestSpecBuilder.addQueryParam(phoneNumber);
        }

        return requestSpecBuilder;
    }

    @Override
    protected void createRequest() {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath);
        requestSpecification = this.addQueryParam(requestSpecBuilder).build();
        requestSpecification = requestSpecBuilder.build();
        
    }

    @Override
    protected void executeRequest() {
        apiResponse = given().spec(requestSpecification).auth().oauth2(token).get();
    }

    @Override
    protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecification = responseSpecBuilder.build();
        apiResponse.then().spec(responseSpecification);
    }
}
