package dao.Implementation;

import dao.JPA;
import dao.IAccountDao;
import domain.Account;
import domain.Kwet;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@JPA
public class AccountDao extends DaoManager<Account> implements IAccountDao {

    public List<Account> getAllFollowersOfAccount(String userName) {
        TypedQuery<Account> query = em.createNamedQuery("account.findFollowers", Account.class);
        query.setParameter("Username", userName);
        List<Account> result = query.getResultList();
        return result;
    }

    public List<Account> getAllFollowingsOfAccount(String userName) {
        TypedQuery<Account> query = em.createNamedQuery("account.findFollowings", Account.class);
        query.setParameter("Username", userName);
        List<Account> result = query.getResultList();
        return result;
    }

    @Override
    public Account findByName(String name) {
        TypedQuery<Account> query = em.createNamedQuery("account.findByName", Account.class);
        query.setParameter("Username", name);
        List<Account> result = query.getResultList();
        return result.get(0);
    }

    @Override
    public Account addFollower(Account user, Account follower) {
        ArrayList<Account> followers = new ArrayList<>();
        followers.add(follower);
        user.setFollowers(followers);
        em.persist(user);

        ArrayList<Account> followings = new ArrayList<>();
        followings.add(user);
        follower.setFollowings(followings);
        em.persist(follower);
        return user;
    }

    @Override
    public Account addFollowing(Account user, Account following) {
        ArrayList<Account> followings = new ArrayList<>();
        followings.add(following);
        user.setFollowings(followings);
        em.persist(user);

        ArrayList<Account> followers = new ArrayList<>();
        followers.add(user);
        following.setFollowers(followers);
        em.persist(following);
        return user;
    }

    @Override
    public Account addKwet(Account account, Kwet kwet) {
        ArrayList<Kwet> kwets = new ArrayList<>();
        kwets.add(kwet);
        account.setKwets(kwets);
        em.persist(account);

        kwet.setOwner(account);
        em.persist(kwet);
        return account;
    }

    @Override
    public ArrayList<Account> getAllAccounts() {
        Query query = em.createQuery("SELECT a FROM Account a");
        return new ArrayList<>(query.getResultList());
    }
}
