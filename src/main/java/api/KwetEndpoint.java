package api;

import domain.Kwet;
import services.MessageService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("message")
public class KwetEndpoint extends Application {

    @Inject
    MessageService messageService;

    @GET
    @Path("{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessageOfAccount(@PathParam("name") String name) {
        List<Kwet> kwets = new ArrayList<Kwet>(messageService.findMessagesOfAccount(name)){};
        return Response.ok(messageService.convertAllToJson(kwets)).build();
    }

    @GET
    @Path("search/{word}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessageWithWord(@PathParam("word") String word) {
        List<Kwet> kwets = new ArrayList<Kwet>(messageService.findMessagesLikeText(word)){};
        return Response.ok(messageService.convertAllToJson(kwets)).build();
    }
}
