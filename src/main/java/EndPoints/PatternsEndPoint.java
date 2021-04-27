package EndPoints;

import Utilities.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatternsEndPoint {

    PropertiesReader propertiesReader;
    RequestSpecification request;

    public PatternsEndPoint(){
        propertiesReader = new PropertiesReader();
        RestAssured.baseURI = propertiesReader.getBaseURL();
        request = RestAssured.given();
    }

    //Method to be used as a get request to retrieve patterns data
    public Response getPatterns(){
        return request.get(propertiesReader.getPatternsEndPointURL());
    }

    //Method to verify that the num view for every pattern should be bigger than the expected number otherwise will return false
    public boolean verifyNumViewsPatters(Response response, int expectedNumber){
        XmlPath xmlPath = response.xmlPath();
        int resultsNumber = Integer.parseInt(xmlPath.get("patterns.@numResults"));
        for(int i=0; i<resultsNumber; i++){
            if(xmlPath.getInt("patterns.pattern["+i+"].numViews")<expectedNumber) {
                return false;
            }
        }
        return true;
    }

}
