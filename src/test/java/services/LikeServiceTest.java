package services;

import dao.ILikesDao;
import domain.Account;
import domain.Kwet;
import domain.Like;
import domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LikeServiceTest {

    private Like like;
    private LikeService likeService;

    @Mock
    private ILikesDao heartsDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        likeService = new LikeService(heartsDao);

        User userOne = new User("Swagger", "123", "swag@hotmail.com");
        User userTwo = new User("Vamana", "123", "vam@hotmail.com");

        Account account = new Account(userOne, null, null, "location", "bio");
        Account owner = new Account(userTwo, null, null, "location", "bio");
        Kwet kwet = new Kwet(owner, "text");
        like = new Like(account, kwet);
    }

    @Test
    public void getAllLikesOfMessage_found() {
        List<Like> likeExpected = new ArrayList<>();
        likeExpected.add(like);
        when(likeService.getAllLikesOfMessage(1L)).thenReturn(likeExpected);
        List<Like> likeFound = likeService.getAllLikesOfMessage(1L);
        assertThat(likeFound, is(likeExpected));
    }

    @Test
    public void getAllLikedAccountsOfKwet() {
        List<Like> likeExpected = new ArrayList<>();
        likeExpected.add(like);
        when(likeService.getAllLikedAccountsOfMessage(1L)).thenReturn(likeExpected);
        List<Like> likeFound = likeService.getAllLikesOfMessage(1L);
        assertThat(likeFound, is(likeExpected));
    }
}
