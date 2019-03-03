package collections;

import dao.AccountDao;
import domain.Account;
import domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

public class TestAccountDao {

    private AccountDao accountDao;
    private Account accountOne;
    private Account accountTwo;
    private Account accountThree;

    private ArrayList<Account> whoIFollow = new ArrayList<>();
    private ArrayList<Account> whoFollowMe = new ArrayList<>();

    private ArrayList<Account> emptyFollower = new ArrayList<>();
    private ArrayList<Account> emptyFollowing = new ArrayList<>();

    @Before
    public void testSetupAccountDaoColl() {
        accountDao = new AccountDao();

        User userOne = new User("Swagger", "123", "swag@hotmail.com");
        User userTwo = new User("Vamana", "123", "vam@hotmail.com");
        User userThree = new User("hank", "123", "hank@hotmail.com");

        accountOne = new Account(userOne, whoIFollow, whoFollowMe, "Eindhovski", "Български");
        accountTwo = new Account(userTwo, emptyFollower, emptyFollowing, "Waggelningen", "klappen?");
        accountThree = new Account(userThree, whoIFollow, whoFollowMe, "Je boi limbuarg", "MEIN NOTITIE");

        whoIFollow.add(accountTwo);
        whoIFollow.add(accountThree);

        whoFollowMe.add(accountTwo);
        whoFollowMe.add(accountThree);

        accountDao.addAccount(accountOne);
        accountDao.addAccount(accountTwo);
        accountDao.addAccount(accountThree);
    }

    @Test
    public void testGetAccount_found() {
        assertEquals(accountOne, accountDao.getAccount(accountOne));
    }

    @Test
    public void testAddAcount_new() {

        User user = new User("banaan", "123", "ban@aan.nl");

        Account newAccount = new Account(user, null, null, "Waggelningen", "appel");
        accountDao.addAccount(newAccount);
        assertEquals(newAccount, accountDao.getAccount(newAccount));
    }

    @Test
    public void testRemoveAccount_existing() {
        accountDao.removeAccount(accountThree);
        assertNull(accountDao.findAccountByName("hank"));
    }

    @Test
    public void testGetAllAccounts_expectAmount() {
        assertEquals(3, accountDao.getAllAccounts().size());
    }

    @Test
    public void testFindAccountByName_found() {
        assertEquals(accountOne, accountDao.findAccountByName("Swagger"));
    }

    @Test
    public void testGetAllFollowersOfAccount_count() {
        assertEquals(2, accountDao.getAllFollowersOfAccount("Swagger").size());
    }

    @Test
    public void testGetAllFollowersOfAccount_null() {
        assertEquals(0, accountDao.getAllFollowersOfAccount("Vamana").size());
    }

    @Test
    public void testGetAllStalkingOfAccount_count() {
        assertEquals(2, accountDao.getAllFollowingsOfAccount("Swagger").size());
    }

    @Test
    public void testGetAllStalkingOfAccount_null() {
        assertEquals(0, accountDao.getAllFollowingsOfAccount("Vamana").size());
    }
}
