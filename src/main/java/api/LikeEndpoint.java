package api;

import domain.Like;
import services.LikeService;

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

@Path("like")
public class LikeEndpoint extends Application {

    @Inject
    private LikeService likeService;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getLikesOfMessage(@PathParam("id") Long id) {
        List<Like> likes = new ArrayList<Like>(likeService.getAllLikesOfMessage(id)){};
        return Response.ok(likeService.convertAllToJson(likes)).build();
    }

    @GET
    @Path("account/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAccountsThatLikedOfMessage(@PathParam("id") Long id) {
        List<Like> likes = new ArrayList<Like>(likeService.getAllLikedAccountsOfMessage(id)){};
        return Response.ok(likeService.convertAllToJson(likes)).build();
    }
}
