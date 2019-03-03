package services;

import dao.ILikesDao;
import dao.JPA;
import domain.Like;

import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class LikeService {

    @Inject
    @JPA
    private ILikesDao likesDao;

    public LikeService(){
    }

    public LikeService(ILikesDao likesDao){
        this.likesDao = likesDao;
    }

    public Like create(Like like){ return this.likesDao.add(like);}

    public void remove(Like like){ this.likesDao.delete(like);}

    public List<Like> getAllLikesOfMessage(Long message){ return this.likesDao.getAllLikesOfKwet(message);}

    public List<Like> getAllLikedAccountsOfMessage(Long message) {return this.likesDao.getAllLikedAccountsOfKwet(message);}

    public List<JsonObject> convertAllToJson(List<Like> likes) {
        List<JsonObject> convertedObjects = new ArrayList<>();
        for (Like like : likes) {
            convertedObjects.add(like.convertToJson());
        }
        return convertedObjects;
    }
}
