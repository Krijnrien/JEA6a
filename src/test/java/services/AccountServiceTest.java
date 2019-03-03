package services;

import dao.IAccountDao;
import domain.Account;
import domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {


    private User userOne;
    private User userTwo;

    private Account accountOne;
    private Account accountTwo;
    private AccountService accountService;

    @Mock
    private IAccountDao accountDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        userOne = new User("Vamana2", "password", "Vamana@email.com");
        accountOne = new Account(userOne, null, null, "Eindhovski", "Български");

        userTwo = new User("Swagger2", "password", "Swagger@email.com");
        accountTwo = new Account(userTwo, null, null, "Eindhovski", "Български");
    }

    @Test
    public void addFollower_added() {
        accountService.addFollower(accountOne, accountTwo);
        verify(accountDao, Mockito.times(1)).addFollower(accountOne, accountTwo);
    }

    @Test
    public void addFollowing_added() {
        accountService.addFollowing(accountOne, accountTwo);
        verify(accountDao, Mockito.times(1)).addFollowing(accountOne, accountTwo);
    }

    @Test
    public void findFollowerByAccount_found() {
        List<Account> accountExpected = new ArrayList<>();
        accountExpected.add(accountTwo);
        when(accountService.getAllFollowers("accountOne")).thenReturn(accountExpected);
        List<Account> accountFound = accountService.getAllFollowers("accountOne");
        assertThat(accountFound, is(accountExpected));
    }

    @Test
    public void findFollowingByAccount_found() {
        List<Account> accountExpected = new ArrayList<>();
        accountExpected.add(accountTwo);
        when(accountService.getAllFollowings("accountOne")).thenReturn(accountExpected);
        List<Account> accountFound = accountService.getAllFollowings("accountOne");
        assertThat(accountFound, is(accountExpected));
    }

    @Test
    public void removeAccount_removed() {
        verify(accountDao, Mockito.times(0)).delete(accountOne);
    }
}
