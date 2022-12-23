package gr.codehub.europeanwebshop.resources;

import gr.codehub.europeanwebshop.dto.CustomerDto;
import gr.codehub.europeanwebshop.dto.RestApiResult;
import gr.codehub.europeanwebshop.exception.CustomerException;
import gr.codehub.europeanwebshop.model.Customer;
import gr.codehub.europeanwebshop.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
@Path("eshop")
public class CustomerResource {

    @Inject
    private CustomerService customerService;

    @GET
    @Path("ping")
    public Response ping() {
        return Response
                .ok("pang")
                .build();
    }

    @GET
    @Path("customer")
    @Produces("application/json")
    public List<CustomerDto> getCustomer(@QueryParam("name") String name) {
        return customerService.geCustomers(name);
    }

    @GET
    @Path("customer/{customerID}")
    @Produces("application/json")
    public RestApiResult<CustomerDto> getCustomer(@PathParam("customerID") long customerID) {
        return customerService.getCustomer(customerID);
    }

    @POST
    @Path("customer")
    @Produces("application/json")
    @Consumes("application/json")
    public void createCustomer(CustomerDto customer) throws CustomerException {
        customerService.createCustomer(customer);
    }

    @DELETE
    @Path("customer/{customerID}")
    @Produces("application/json")
    public boolean deleteCustomer(@PathParam("customerID") long customerID) {
        return customerService.deleteCustomer(customerID);
    }

}
