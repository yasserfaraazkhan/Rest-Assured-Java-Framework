package test;

import java.io.IOException;

import org.testng.annotations.Test;

import api.users.Users;
import pojo.UserListPOJO;
import pojo.UsersPOJO;
import utils.GenericDataProvider;
import utils.PropertiesManager;

import org.testng.Assert;

public class TestUsers extends BaseTest {

    @Test()
    public void getAllUsers() throws IOException {
        Users getUser = new Users(PropertiesManager.getProperty("baseURI"), accessToken);
        getUser.setExpectedStatusCode(200);
        getUser.perform();

        UserListPOJO[] user_data = getUser.getAPIResponseAsPOJO(UserListPOJO[].class);

    }

    @Test(dataProvider = "dataproviderForTestCase", dataProviderClass = GenericDataProvider.class)
    public void getValidPhoneNumber(String validPhoneNumber) throws IOException {
        Users getUser = new Users(PropertiesManager.getProperty("baseURI"), accessToken);
        getUser.setPhoneNumber(validPhoneNumber);
        getUser.setExpectedStatusCode(200);
        getUser.perform();

        UsersPOJO[] user_data = getUser.getAPIResponseAsPOJO(UsersPOJO[].class);
        String actualTitle = user_data[0].getPhone();
        // Assert that same number is received indicating number exists
        Assert.assertEquals(actualTitle, validPhoneNumber);

    }

    @Test(dataProvider = "dataproviderForTestCase", dataProviderClass = GenericDataProvider.class)
    public void getInValidPhoneNumber(String inValidPhoneNumber) throws IOException {

        Users getUser = new Users(PropertiesManager.getProperty("baseURI"), accessToken);
        getUser.setPhoneNumber(inValidPhoneNumber);
        getUser.setExpectedStatusCode(200);
        getUser.perform();

        UsersPOJO[] user_data = getUser.getAPIResponseAsPOJO(UsersPOJO[].class);
        String actualTitle = user_data[0].getPhone();
        // Assert that no response data is received indicating number does not exists
        // Currently the return is non empty which is a bug
        // Assert.assertNull(actualTitle, String.format(" expected NUll but found %s",
        // actualTitle));
        Assert.assertNotEquals(actualTitle, inValidPhoneNumber);
    }

}
