package api;

import domain.Account;
import services.AccountService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("account")
public class UserEndpoint extends Application{

    @Inject
    AccountService accountService;

    @GET
    @Path("followers/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFollowersOfAccount(@PathParam("username") String name) {
        GenericEntity entity = new GenericEntity<List<Account>>(accountService.getAllFollowers(name)){};
        return Response.ok(entity).build();
    }

    @GET
    @Path("following/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFollowingOfAccount(@PathParam("username") String name) {
        GenericEntity entity = new GenericEntity<List<Account>>(accountService.getAllFollowings(name)){};
        return Response.ok(entity).build();
    }

}
