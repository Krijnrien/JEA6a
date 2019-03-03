package JPA;

import dao.Implementation.UserDao;
import domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class UserDaoTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("KwetterPUTest");
    private EntityTransaction tx;

    private UserDao userDao;
    private User user;

    @Before
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        tx = em.getTransaction();

        this.userDao = new UserDao();
        userDao.setEm(em);

        user = new User("Violet", "password", "violet@email.com");
    }

    @Test
    public void createUser() {
        tx.begin();
        userDao.add(user);
        tx.commit();

        tx.begin();
        List<User> users = userDao.getAllUsers();
        tx.commit();

        Assert.assertEquals(1, users.size());
        Assert.assertNotEquals(2, users.size());
    }

    @Test
    public void deleteUser() {
        tx.begin();
        userDao.add(user);
        tx.commit();

        List<User> usersFound = userDao.getAllUsers();

        Assert.assertEquals(1, usersFound.size());
        Assert.assertNotEquals(0, usersFound.size());

        tx.begin();
        userDao.delete(user);
        tx.commit();

        List<User> userFoundDeleted = userDao.getAllUsers();

        Assert.assertEquals(0, userFoundDeleted.size());
        Assert.assertNotEquals(1, userFoundDeleted.size());
    }

    @Test
    public void findUser_getUsername() {
        tx.begin();
        userDao.add(user);
        tx.commit();

        User userFound = userDao.findById(1L);

        Assert.assertEquals(user.getUsername(), userFound.getUsername());
    }

    @Test
    public void findUser_getAll() {
        User user1 = new User("Vamana", "password", "vaman@email.com");

        tx.begin();
        userDao.add(user);
        userDao.add(user1);
        tx.commit();

        List<User> usersFound = userDao.getAllUsers();

        Assert.assertEquals(2, usersFound.size());
        Assert.assertNotEquals(0, usersFound.size());
        Assert.assertNotEquals(1, usersFound.size());
    }
}
