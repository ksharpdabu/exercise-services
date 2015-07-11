package com.pluralsight;

import java.util.List;





import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Create;


@Path("activities")
// http://localhost:8080/exercise-services/activities
public class ActivityResource {
	
	String result;

//	String a;
	
	@POST
	@Path("create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Activity createActivityParams(MultivaluedMap<String,String> formParams) {
		
		Create mCreate = new Create();
		result = mCreate.CreateUser(formParams.getFirst("phone"), formParams.getFirst("pass"));
		
		
		Activity activity = new Activity();

		activity.setCode(result);
		
		
		return activity;
		
		
		
		
	}
	



	

}
