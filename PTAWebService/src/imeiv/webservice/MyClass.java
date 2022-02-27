package imeiv.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("webservice")
@Consumes("application/json")
@Produces("application/json")
public class MyClass {
    public MyClass() {
        super();
    }

    @GET
    @Produces("application/json")
    @Path("/all")
    public List doGetAllInfo() {
        return null;
    }
}
