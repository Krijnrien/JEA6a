package collections;

import dao.UserDao;
import domain.User;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestUserDao {

    private static UserDao userDao;
    private static User userOne;
    private static User userTwo;

    @BeforeClass
    public static void testSetupUserDaoColl() {
        userDao = new UserDao();

        userOne = new User("Swagger", "123", "swag@hotmail.com");
        userTwo = new User("Vamana", "456", "vam@hotmail.com");

        userDao.addUser(userOne);
        userDao.addUser(userTwo);
    }

    @Test
    public void testFindByUserName_existing() {
        assertEquals(userOne, userDao.findUserByName("Swagger"));
    }

    @Test()
    public void testFindUserName_notExist() {
        assertNull(userDao.findUserByName("phony"));
    }

    @Test
    public void testAddUser_success() {
        User newUser = new User("new", "pass", "email");
        userDao.addUser(newUser);
        assertEquals(newUser, userDao.findUserByName("new"));
    }

    @Test
    public void testRemoveUser_byUsername() {
        userDao.removeUser(userTwo);
        assertNull(userDao.findUserByName("Vamana"));
    }
}
