package Resources;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.openqa.selenium.remote.html5.AddLocationContext;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Reused  {
	static RequestSpecification req;
	
	public RequestSpecification requestBuild() throws IOException
	{
		if(req==null)
		{
		PrintStream PS = new PrintStream(new FileOutputStream("Logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(GetProperties("baseUrl")).setContentType(ContentType.JSON).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(PS))
				.addFilter(ResponseLoggingFilter.logResponseTo(PS))
				.build();
		}
		return req;
	}
	
	public String getjsonpath(Response res,String Key)
	{
		String Respnse = res.asString();
		JsonPath JSP = new JsonPath(Respnse);
		return JSP.get(Key).toString();
		
	}
	
	public static String GetProperties(String Key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream FIS = new FileInputStream("C:\\Users\\Mann\\eclipse-workspace\\AutomationCucumber\\src\\test\\java\\Resources\\AppConfig.properties");
		prop.load(FIS);
		return prop.getProperty(Key);
				
	}
}
