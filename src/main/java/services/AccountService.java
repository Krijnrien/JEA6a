//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package services;

import dao.IAccountDao;
import dao.JPA;
import domain.Account;
import domain.Kwet;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AccountService {
    @Inject
    @JPA
    private IAccountDao accountDao;

    public AccountService() {
    }

    public AccountService(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account create(Account account) {
        return (Account) this.accountDao.add(account);
    }

    public void delete(Account account) {
        this.accountDao.delete(account);
    }

    public Account findByName(String name) {
        return this.accountDao.findByName(name);
    }

    public Account findById(Long id) {
        return (Account) this.accountDao.findById(id);
    }

    public Account findAccount(Account account) {
        return (Account) this.accountDao.findObject(account);
    }

    public List<Account> getAllFollowers(String userName) {
        return this.accountDao.getAllFollowersOfAccount(userName);
    }

    public List<Account> getAllFollowings(String userName) {
        return this.accountDao.getAllFollowingsOfAccount(userName);
    }

    public Account addFollower(Account user, Account follower) {
        return this.accountDao.addFollower(user, follower);
    }

    public Account addFollowing(Account user, Account following) {
        return this.accountDao.addFollowing(user, following);
    }

    public Account addKwet(Account account, Kwet Kwet) {
        return this.accountDao.addKwet(account, Kwet);
    }

}
