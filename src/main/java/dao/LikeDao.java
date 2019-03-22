package dao;

import domain.Account;
import domain.Like;
import domain.Message;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class LikeDaoColl {

    CopyOnWriteArrayList<Like> likes = new CopyOnWriteArrayList<>();

    public void addHeart(Like like){
        likes.add(like);
    }

    public void removeHeart(Like like){
        likes.remove(like);
    }

    public ArrayList<Like> getAllHeartsOfMessage(Message message){
        ArrayList<Like> heartsOfMessage = new ArrayList<>();

        for(Like like : likes){
            if(like.getLiked().equals(message)){
                heartsOfMessage.add(like);
            }
        }

        return heartsOfMessage;
    }

    public ArrayList<Account> getAllHeartedAccountsOfMessage(Message message){
        ArrayList<Account> accounts = new ArrayList<>();

        for(Like like : likes){
            if(like.getLiked().equals(message)){
                accounts.add(like.getLiker());
            }
        }
        return accounts;
    }
}
