package UnitTests;

import dao.UserDaoColl;
import domain.User;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestUserDaoColl {

    private static UserDaoColl userDaoColl;
    private static User userOne;
    private static User userTwo;

    @BeforeClass
    public static void testSetupUserDaoColl(){
        userDaoColl = new UserDaoColl();

        userOne = new User("Violet", "myPass");
        userTwo = new User("Thomas", "myPass");

        userDaoColl.addUser(userOne);
        userDaoColl.addUser(userTwo);
    }

    @Test
    public void testFindByUserName_ExcistingUserName_Succesfull(){
        assertEquals("Found user equals given", userOne, userDaoColl.findUserByName("Violet"));
    }

    @Test()
    public void testFindUserName_NonExcistingUser_Null(){
        assertNull(userDaoColl.findUserByName("IAmFake"));
    }

    @Test
    public void testAddUser_WithCompleteUser_SuccesfullSaved(){
        User newUser = new User("IamNew", "myPassword");

        userDaoColl.addUser(newUser);

        assertEquals("The added users are the same", newUser, userDaoColl.findUserByName("IamNew"));
    }

    @Test
    public void testRemoveUser_WithCompleteUser_SuccesfullRemoved(){
        userDaoColl.removeUser(userTwo);
        assertNull(userDaoColl.findUserByName("Thomas"));
    }
}
