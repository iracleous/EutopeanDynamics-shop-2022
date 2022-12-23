package gr.codehub.europeanwebshop.resources;

import gr.codehub.europeanwebshop.model.Person;
 import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;


/**
 *
 * @author 
 */
@Path("eshop")
public class JavaEE8Resource {
    
    @GET
    @Path("ping")
    public Response ping(){
        return Response
                .ok("pang")
                .build();
    }
    
    @GET
    @Path("person")
    @Produces("application/json")
    public Person getPerson(){
        Person person = new Person();
        person.setId(7l);
        person.setName("George");
        return person;
    }
    
}
