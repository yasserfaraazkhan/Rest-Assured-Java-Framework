package api.auth;

import api.BaseAPI;
import com.google.common.base.Joiner;
import com.jayway.jsonpath.JsonPath;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Created by Yasser Khan on 15-06-2020.
 */
public class PostToken extends BaseAPI {

    public static final Logger logger = Logger.getLogger(BaseAPI.class);

    String apiPath = "/authenticate";
    String contentType;
    Map<String, String> bodyParams;
    String token;

    public PostToken(String baseURI) {
        super(baseURI);
        bodyParams = new HashMap<String, String>();
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void addBodyParam(String key, String value) {
        bodyParams.put(key, value);
    }

    public String getAccessToken() {
        return token;
    }

    @Override
    protected void createRequest() {
        logger.info("Creating request");
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath);
        requestSpecBuilder.setContentType(contentType);
        requestSpecBuilder.setBody(bodyParams);
        requestSpecification = requestSpecBuilder.build();
    }

    @Override
    protected void executeRequest() {
        logger.info("Executing request");
        apiResponse = given().spec(requestSpecification).post();
    }

    @Override
    protected void validateResponse() {
        logger.info("Validating response");
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecification = responseSpecBuilder.build();
        apiResponse.then().spec(responseSpecification);
        token = JsonPath.read(apiResponse.asString(), "token");
    }
}
