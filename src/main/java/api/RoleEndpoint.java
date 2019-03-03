package api;

import domain.Role;
import services.RoleService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("role")
public class RoleEndpoint extends Application {

    @Inject
    RoleService roleService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<Role> roles = new ArrayList<Role>(roleService.getAllRoles()) {
        };
        return Response.ok(roleService.convertAllToJson(roles)).build();
    }

    @GET
    @Path("{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessageOfAccount(@PathParam("name") String name) {
        List<Role> roles = new ArrayList<Role>(roleService.getAllAccountsWithRole(name)) {};
        return Response.ok(roleService.convertAllToJson(roles)).build();
    }
}
