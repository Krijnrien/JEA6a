package dao;

import domain.Kwet;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class KwetDao {

    private CopyOnWriteArrayList<Kwet> kwets = new CopyOnWriteArrayList<>();

    public void addMessage(Kwet kwet){
        kwets.add(kwet);
    }

    public void removeMessage(Kwet kwet){
        kwets.remove(kwet);
    }

    public ArrayList<Kwet> getAllMessages(){
        return new ArrayList<>(kwets);
    }

    public Kwet findMessagesOfAccount(String name){
        for(Kwet kwet : kwets){
            if(kwet.getOwner().getUser().getUsername().contentEquals(name)){
                return kwet;
            }
        }
        return null;
    }

    public Kwet findMessagesWithWordInText(String word){
        for(Kwet kwet : kwets){
            if(kwet.getText().contains(word)){
                return kwet;
            }
        }
        return null;
    }
}
