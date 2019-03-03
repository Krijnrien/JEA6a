package services;

import dao.IKwetDao;
import dao.JPA;
import domain.Account;
import domain.Kwet;
import domain.Like;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MessageService {

    @Inject
    @JPA
    private IKwetDao messageDao;

    public MessageService(){

    }

    public MessageService(IKwetDao messageDao){
        this.messageDao = messageDao;
    }

    public Kwet create(Kwet kwet){return this.messageDao.add(kwet);}

    public void delete(Kwet kwet){this.messageDao.delete(kwet);}

    public Kwet findById(Long id){
        return this.messageDao.findById(id);
    }

    public Kwet findMessage(Kwet kwet){
        return this.messageDao.findObject(kwet);
    }

    public List<Kwet> findMessagesOfAccount(String userName){return this.messageDao.findMessagesByUsername(userName);}

    public List<Kwet> findMessagesLikeText(String word){return this.messageDao.findMessagesLikeText(word);}

    public Kwet addAccount(Kwet kwet, Account account) {return this.messageDao.addAccount(kwet, account);}

    public Kwet addLike(Kwet kwet, Like like) {return this.messageDao.addLike(kwet, like);}

    public List<JsonObject> convertAllToJson(List<Kwet> kwets) {
        List<JsonObject> convertedObjects = new ArrayList<>();
        for (Kwet kwet : kwets) {
            convertedObjects.add(kwet.convertToJson());
        }
        return convertedObjects;
    }
}
