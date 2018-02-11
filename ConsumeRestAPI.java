package com.howtodoinjava.jersey.beans;

//https://howtodoinjava.com/jersey/jersey-restful-client-api-authentication-example/
import java.io.IOException;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class ConsumeRestAPI {
	public static void main(String[] args) throws IOException
	{
	    httpGETCollectionExample();
	}
	 
	private static void httpGETCollectionExample()
	{
	    ClientConfig clientConfig = new ClientConfig();
	 
	    HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("howtodoinjava", "password");
	    clientConfig.register( feature) ;
	 
	    clientConfig.register(JacksonFeature.class);
	 
	    Client client = ClientBuilder.newClient( clientConfig );
	    WebTarget webTarget = client.target("http://localhost:8080/JerseyDemos/rest").path("employees");
	     
	    Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
	    Response response = invocationBuilder.get();
	     
	    System.out.println(response.getStatus());
	    System.out.println(response.getStatusInfo());
	     
	  /*  if(response.getStatus() == 200)
	    {
	        Employee employees = response.readEntity(Employee.class);
	        List<Employee> listOfEmployees = employees.getEmployeeList();
	        System.out.println(Arrays.toString( listOfEmployees.toArray(new Employee[listOfEmployees.size()]) ));
	    }*/
	}
}
