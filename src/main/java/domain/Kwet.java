package domain;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "kwet.findMessageByName", query = "SELECT m FROM Kwet m WHERE m.Owner.user.Username = :name"),
        @NamedQuery(name = "kwet.findMessageByWord", query = "SELECT m FROM Kwet m WHERE m.Text = :word")})
public class Kwet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne(cascade = CascadeType.ALL)
    private Account Owner;

    private String Text;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Like> likes;

    public Kwet(){

    }

    public Kwet(Account owner, String text){
        this.Owner = owner;
        this.Text = text;
    }

    public JsonObject convertToJson(){
        return Json.createObjectBuilder()
                .add("id", this.Id)
                .add("owner", this.Owner.getUser().getUsername())
                .add("text", this.Text)
                .add("likes", this.likes.size())
                .build();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Account getOwner() {
        return Owner;
    }

    public void setOwner(Account owner) {
        Owner = owner;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }
}
