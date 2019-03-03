package web;

import domain.Account;
import domain.User;
import services.AccountService;
import services.UserService;
import utils.Redir;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("userBean")
@ViewScoped
public class UserBean implements Serializable {

    @Inject
    private UserService userService;
    @Inject
    private AccountService accountService;

    private String username;
    private String password;
    private String emailAddress;
    private String usergroupname = "regulars";


    @PostConstruct
    public void init() {

    }

    public void createUser() {
        if (!this.username.isEmpty() && !this.password.isEmpty() && !this.emailAddress.isEmpty()) {
            User newUser = new User(this.username, this.password, this.emailAddress);
            this.userService.create(newUser);

            Account newAccount = new Account();
            newAccount.setUser(newUser);
            accountService.create(newAccount);
        }
        Redir.redirect("/pages/admin/admin.xhtml");
    }

    public void deleteUser(User user) {
        userService.remove(user);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
