package services;

import dao.IKwetDao;
import domain.Kwet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KwetServiceTest {

    private Kwet kwet;
    private MessageService messageService;

    @Mock
    private IKwetDao messageDao;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        messageService = new MessageService(messageDao);
    }

    @Test
    public void getMessage_MessageID_MessageFound(){

    }

    @Test
    public void getAccountOfMessage_MessageID_AccountNameFound(){

    }

    @Test
    public void getAllTrendsOfMessage_MessageID_ListOfTrends(){

    }

    @Test
    public void getAllHeartsOfMessage_MessageID_ListOfHearts(){

    }
}
