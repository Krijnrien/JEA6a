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

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {


    private User userOne;
    private User userTwo;

    private Account accountOne;
    private Account accountTwo;
    private UserService userService;

    @Mock
    private IAccountDao accountDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(accountDao);

        userOne = new User("Vamana", "password", "Vamana@email.com");
        accountOne = new Account(userOne, null, null, "Eindhovski", "Български");

        userTwo = new User("Swagger", "password", "Swagger@email.com");
        accountTwo = new Account(userTwo, null, null, "Eindhovski", "Български");
    }

    @Test
    public void createAccount_added() {
        userService.create(userOne);
        verify(accountDao, Mockito.times(1)).add(accountOne);
    }

    @Test
    public void findAccountByName_found() {
        when(userService.findByName("Vamana")).thenReturn(userOne);
        User accountFound = userService.findByName("Vamana");
        assertThat(accountFound, is(accountOne));
    }

    @Test
    public void removeAccount_removed() {
        verify(accountDao, Mockito.times(0)).delete(accountOne);
    }
}
