package domain;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "like.getAllLikedofKwet", query = "SELECT h FROM Like h WHERE h.Liked = :kwet"),
        @NamedQuery(name = "like.getAllAccountsThatLikedKwet", query = "SELECT h.Liker FROM Like h WHERE h.Liked = :kwet")
})
public class Like implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Account Liker;

    @ManyToOne(cascade = CascadeType.ALL)
    private Kwet Liked;

    public Like(){
    }

    public Like(Account liker, Kwet liked){
        this.Liker = liker;
        this.Liked = liked;
    }

    public JsonObject convertToJson(){
        return Json.createObjectBuilder()
                .add("id", this.Id)
                .add("liker", this.Liker.getUser().getUsername())
                .add("liked", this.Liked.getId())
                .build();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Account getLiker() {
        return Liker;
    }

    public void setLiker(Account liker) {
        Liker = liker;
    }

    public Kwet getLiked() {
        return Liked;
    }

    public void setLiked(Kwet liked) {
        Liked = liked;
    }
}
