package com.journaldev.spring.manager;
import org.codehaus.jettison.json.JSONObject;

import com.journaldev.spring.model.Schedule;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class EntityManager implements IEntityManager<Schedule>{
	

	public JSONObject getgetOjectFromRestService(String Url, Schedule object) {
		try{
			
			 ClientConfig clientConfig = new DefaultClientConfig();
			 
			 clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			  
			 Client client = Client.create(clientConfig);

	          WebResource webResource = client.resource(Url);

	          ClientResponse response = webResource.accept("application/json").type("application/json").post(ClientResponse.class, object);

	          if (response.getStatus() != 200) {

	              throw new RuntimeException("Failed : HTTP error code : "
	                      + response.getStatus());

	          }

	          String output = response.getEntity(String.class);
	          return   new JSONObject(output);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	         
}
