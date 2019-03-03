package web;

import domain.Kwet;
import services.MessageService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("messageBean")
@ViewScoped
public class MessageBean implements Serializable {

    @Inject
    private MessageService messageService;
    private List<Kwet> messageList;
    private Kwet message;

    public List<Kwet> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Kwet> messageList) {
        this.messageList = messageList;
    }

    public Kwet getMessage() {
        return message;
    }

    public void setMessage(Kwet message) {
        this.message = message;
    }
}
