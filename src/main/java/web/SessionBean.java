package web;

import domain.User;
import org.omnifaces.util.Faces;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.Serializable;

import static org.omnifaces.util.Faces.invalidateSession;

@Named
@SessionScoped
public class SessionBean implements Serializable{

    private User loggedInUser;

    public void logout() throws ServletException {
        loggedInUser = null;

        Faces.logout();
        invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/JEA_Kwetter");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
