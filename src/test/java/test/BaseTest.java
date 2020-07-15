package test;

import api.auth.PostToken;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import utils.PropertiesManager;

public class BaseTest {

	public static final Logger logger = Logger.getLogger(BaseTest.class);
	protected static String accessToken;

	@BeforeSuite(alwaysRun = true)
	public void BeforeSuite() throws Exception {
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
		PropertiesManager.initializeProperties();
		logger.info("Properties Initialized");

		PostToken postToken = new PostToken(PropertiesManager.getProperty("baseURI"));
		postToken.setContentType("application/json");
		postToken.addBodyParam("password", PropertiesManager.getProperty("password"));
		postToken.addBodyParam("username", PropertiesManager.getProperty("username"));
		postToken.setExpectedStatusCode(200);
		postToken.perform();
		accessToken = postToken.getAccessToken();
		logger.info("OAuth Token Received = " + accessToken);
	}
}
