package dao;

import domain.Message;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageDaoColl {

    CopyOnWriteArrayList<Message> messages = new CopyOnWriteArrayList<>();

    public void addMessage(Message message){
        messages.add(message);
    }

    public void removeMessage(Message message){
        messages.remove(message);
    }

    public ArrayList<Message> getAllMessages(){
        return new ArrayList<>(messages);
    }

    public Message findMessagesOfAccount(String name){
        for(Message message : messages){
            if(message.getOwner().contentEquals(name)){
                return message;
            }
        }
        return null;
    }

    public Message findMessagesWithWordInText(String word){
        for(Message message : messages){
            if(message.getText().contains(word)){
                return message;
            }
        }
        return null;
    }
}
