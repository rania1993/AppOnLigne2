package tn.esprit.ressources;



import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.pidevjee.interfaces.InterfaceTaskServiceRemote;

@Path("tasks")
@RequestScoped
public class TaskRessource {

	@EJB
	InterfaceTaskServiceRemote taskmetier;
	
	
	@GET

	@Produces(MediaType.APPLICATION_JSON)
      public Response getAllTasks(){
	
	
	return Response.ok(taskmetier.getAllTasks()).build();
}
	
	
	
	
	
	
	
}
