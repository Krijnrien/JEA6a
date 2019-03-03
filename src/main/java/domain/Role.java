package domain;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name = "role.accountsWithRole", query = "SELECT r.AccountsWithThisRole FROM Role r WHERE r.Name = :name")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Name;

    @OneToOne(cascade = CascadeType.ALL)
    private List<Account> AccountsWithThisRole;

    public Role(){}

    public Role(String name){
        this.Name = name;
    }

    public JsonObject convertToJson(){
        return Json.createObjectBuilder()
                .add("id", this.Id)
                .add("name", this.Name)
                .add("accountswiththisrole", this.AccountsWithThisRole.size())
                .build();
    }

    public long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Account> getAccountsWithThisRole() {
        return AccountsWithThisRole;
    }

    public void setAccountsWithThisRole(List<Account> accountsWithThisRole) {
        AccountsWithThisRole = accountsWithThisRole;
    }
}
