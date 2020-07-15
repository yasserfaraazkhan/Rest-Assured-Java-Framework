package utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class GenericDataProvider {
	@DataProvider(name = "dataproviderForTestCase")
	public static Object[] sampleDataProvider(Method m, ITestContext iTestContext) throws IOException {

		// Getting the method name
		String methodName = m.getName();

		switch (methodName) {
			case "getValidPhoneNumber": {
				String[] phoneNumbers = new String[] { "9972939567", "8037602400", "9995879555" };

				return new String[] { phoneNumbers[new Random().nextInt(phoneNumbers.length)] };
			}
			case "getInValidPhoneNumber": {
				String[] phoneNumbers = new String[] { "12231", "!@32", "Qwerty" };

				return new String[] { phoneNumbers[new Random().nextInt(phoneNumbers.length)] };
			}
			default:
				return new String[] { "No Data ! Please initialize a data provider" };
		}

	}

}
