package dao;

import domain.Account;
import domain.Kwet;
import domain.Like;

import java.util.List;

public interface IKwetDao extends IDaoManager<Kwet> {

    List<Kwet> findMessagesByUsername(String userName);

    List<Kwet> findMessagesLikeText(String word);

    Kwet addAccount(Kwet kwet, Account account);

    Kwet addLike(Kwet kwet, Like like);
}
