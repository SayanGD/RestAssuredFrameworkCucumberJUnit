package utilities;

import java.io.IOException;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SpecificationBuilder
{
	RequestSpecification reqSpec;

	public RequestSpecification getRequestSpecification() throws IOException
	{
		PropertyReader prop=new PropertyReader();
		String baseURI=prop.getProperty("baseURI");
		String queryParamKey=prop.getProperty("queryParamKey");
		String queryParamValue=prop.getProperty("queryParamValue");

		reqSpec=new RequestSpecBuilder().setBaseUri(baseURI).setContentType(ContentType.JSON).addQueryParam(queryParamKey, queryParamValue).build();
		return reqSpec;
	}
}