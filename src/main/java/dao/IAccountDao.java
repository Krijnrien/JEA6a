package dao;

import domain.Account;
import domain.Kwet;

import java.util.ArrayList;
import java.util.List;

public interface IAccountDao extends IDaoManager<Account> {

    Account findByName(String name);

    List<Account> getAllFollowersOfAccount(String userName);

    List<Account> getAllFollowingsOfAccount(String userName);

    Account addFollower(Account user, Account follower);

    Account addFollowing(Account user, Account following);

    Account addKwet(Account account, Kwet kwet);

    ArrayList<Account> getAllAccounts();
}
