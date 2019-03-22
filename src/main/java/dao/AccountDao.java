package dao;

import domain.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AccountDaoColl {

    CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList<>();

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void removeAccount(Account account){
        accounts.remove(account);
    }

    public Account getAccount(Account account){
        for(Account accountSearchable : accounts){
            if(accountSearchable.equals(account)){
                return account;
            }
        }
        return null;
    }

    public ArrayList<Account> getAllAccounts(){
        return new ArrayList<>(accounts);
    }

    public Account findAccountByName(String userName){
        for(Account account : accounts){
            if(account.getUsername().contentEquals(userName)){
                return account;
            }
        }
        return null;
    }

    public List<Account> getAllFollowersOfAccount(String userName){
        for(Account account : accounts){
            if(account.getUsername().contentEquals(userName)){
                return account.getFollowers();
            }
        }
        return null;
    }

    public List<Account> getAllFolloweesOfAccount(String userName){
        for(Account account : accounts){
            if(account.getUsername().contentEquals(userName)){
                return account.getFollowees();
            }
        }
        return null;
    }
}
