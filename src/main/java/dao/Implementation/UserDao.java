package dao.Implementation;

import dao.JPA;
import dao.IUserDao;
import domain.User;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@JPA
public class UserDao extends DaoManager<User> implements IUserDao {

    public User findUserByName(String userName) {
        TypedQuery<User> query = em.createNamedQuery("user.findByName", User.class);
        query.setParameter("Username", userName);
        List<User> result = query.getResultList();
        return result.get(0);
    }

    @Override
    public ArrayList<User> getAllUsers() {
        Query query = em.createQuery("SELECT u FROM User u");
        return new ArrayList<>(query.getResultList());
    }

    public User findByCredentials(String username, String password) {
        TypedQuery<User> query = em.createNamedQuery("user.findByCredentials", User.class).setParameter("username", username).setParameter("password", password);
        List<User> result = query.getResultList();
        return result.get(0);
    }
}
