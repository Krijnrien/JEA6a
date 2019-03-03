package api;

import domain.Account;
import domain.User;
import services.AccountService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("user")
@Stateless
public class AccountEndpoint {

    @Inject
    AccountService accountService;

    public AccountEndpoint() {
    }

    @GET
    @Path("{Username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccount(@PathParam("Username") String name) {
        Account account = accountService.findByName(name);
        return Response.ok(account.convertToJson()).build();
    }

}
