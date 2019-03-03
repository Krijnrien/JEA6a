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
        @NamedQuery(name = "account.findFollowers", query = "SELECT a.Followers FROM Account a WHERE a.user.Username = :Username"),
        @NamedQuery(name = "account.findFollowings", query = "SELECT a.Followings FROM Account a WHERE a.user.Username = :Username"),
        @NamedQuery(name = "account.findByName", query = "SELECT a FROM Account a WHERE a.user.Username = :Username")})
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Account> Followers;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Account> Followings;

    private String Location;

    private String Bio;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Kwet> kwets;

    @OneToOne(cascade = CascadeType.ALL)
    private Role role;

    public Account() {
    }

    public Account(User user, List<Account> followers, List<Account> following, String location, String bio) {
        this.user = user;
        this.Followers = followers;
        this.Followings = following;
        this.Location = location;
        this.Bio = bio;
    }

    public JsonObject convertToJson() {
        return Json.createObjectBuilder()
                .add("id", this.Id)
                .add("user", this.user.getUsername())
                .add("followers", this.Followers.size())
                .add("followings", this.Followings.size())
                .add("location", this.Location)
                .add("bio", this.Bio)
//                .add("kwets", this.kwets.size())
//                .add("role", this.role.getId())
                .build();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Account> getFollowers() {
        return Followers;
    }

    public void setFollowers(List<Account> followers) {
        Followers = followers;
    }

    public List<Account> getFollowings() {
        return Followings;
    }

    public void setFollowings(List<Account> followees) {
        Followings = followees;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
    }

    public List<Kwet> getKwets() {
        return kwets;
    }

    public void setKwets(List<Kwet> kwets) {
        this.kwets = kwets;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
