package UnitTests;

import dao.AccountDaoColl;
import domain.Account;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

public class TestAccountDaoColl {

    private AccountDaoColl accountDaoColl;
    private Account accountOne;
    private Account accountTwo;
    private Account accountThree;

    private ArrayList<Account> followers = new ArrayList<>();
    private ArrayList<Account> followees = new ArrayList<>();

    private ArrayList<Account> followersEmpty = new ArrayList<>();
    private ArrayList<Account> followeesEmpty = new ArrayList<>();

    @Before
    public void testSetupAccountDaoColl() {
        accountDaoColl = new AccountDaoColl();

        accountOne = new Account("Violet", followers, followees, "myWebsite", "Tilburg", "my bio");
        accountTwo = new Account("Thomas", followersEmpty, followeesEmpty, "myWebsite", "Tilburg", "my bio");
        accountThree = new Account("Roy", followers, followees, "myWebsite", "Tilburg", "my bio");

        followers.add(accountTwo);
        followers.add(accountThree);

        followees.add(accountTwo);
        followees.add(accountThree);

        accountDaoColl.addAccount(accountOne);
        accountDaoColl.addAccount(accountTwo);
        accountDaoColl.addAccount(accountThree);
    }

    @Test
    public void testGetAccount_ExcistingAccount_FoundTheExcistingAccount(){
        assertEquals("The test was succesfull", accountOne, accountDaoColl.getAccount(accountOne));
    }

    @Test
    public void testAddAcount_NewAccount_AddedTheNewAccount(){
        Account newAccount = new Account("New", null, null, "myWebsite", "Tilburg", "my bio");
        accountDaoColl.addAccount(newAccount);
        assertEquals("New account added", newAccount, accountDaoColl.getAccount(newAccount));
    }

    @Test
    public void testRemoveAccount_ExcistingAccount_RemovedTheAccount(){
        accountDaoColl.removeAccount(accountThree);
        assertNull(accountDaoColl.findAccountByName("Roy"));
    }

    @Test
    public void testGetAllAccounts_ListWithAccount_TheExcistingList(){
        assertEquals("Amount of found accounts is the same as the expected amount", 3, accountDaoColl.getAllAccounts().size());
    }

    @Test
    public void testFindAccountByName_ExcistingAcount_FoundTheExcistingAccount(){
        assertEquals("Found account equals the excepted result", accountOne, accountDaoColl.findAccountByName("Violet"));
    }

    @Test
    public void testGetAllFollowersOfAccount_ExcistingAccount_FoundListOfFollowers(){
        assertEquals("Found amount of followers equals the expected amount", 2, accountDaoColl.getAllFollowersOfAccount("Violet").size());
    }

    @Test
    public void testGetAllFollowersOfAccount_ExcistingAccountWithoutFollowers_FoundEmptyList(){
        assertNull(accountDaoColl.getAllFollowersOfAccount("Thomas"));
    }

    @Test
    public void testGetAllFolloweesOfAccount_ExcistingAccount_FoundListOfFollowees(){
        assertEquals(2, accountDaoColl.getAllFolloweesOfAccount("Violet").size());
    }

    @Test
    public void testGetAllFolloweesOfAccount_ExcistingAccountWithoutFollowees_FoundEmptyList(){
        assertNull(accountDaoColl.getAllFolloweesOfAccount("Thomas"));
    }
}
