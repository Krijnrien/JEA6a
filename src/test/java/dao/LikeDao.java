package dao;

import domain.Account;
import domain.Kwet;
import domain.Like;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class LikeDao {

    CopyOnWriteArrayList<Like> likes = new CopyOnWriteArrayList<>();

    public void addHeart(Like like){
        likes.add(like);
    }

    public void removeHeart(Like like){
        likes.remove(like);
    }

    public ArrayList<Like> getAllHeartsOfMessage(Kwet kwet){
        ArrayList<Like> heartsOfMessage = new ArrayList<>();

        for(Like like : likes){
            if(like.getLiked().equals(kwet)){
                heartsOfMessage.add(like);
            }
        }

        return heartsOfMessage;
    }

    public ArrayList<Account> getAllHeartedAccountsOfMessage(Kwet kwet){
        ArrayList<Account> accounts = new ArrayList<>();

        for(Like like : likes){
            if(like.getLiked().equals(kwet)){
                accounts.add(like.getLiker());
            }
        }
        return accounts;
    }
}
