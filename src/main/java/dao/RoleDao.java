package dao;

import domain.Account;
import domain.Role;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class RoleDaoColl {

    CopyOnWriteArrayList<Role> roles = new CopyOnWriteArrayList<>();

    public void addRole(Role role){
        roles.add(role);
    }

    public void removeRole(Role role){
        roles.remove(role);
    }

    public ArrayList<Role> getAllRoles(){
        return new ArrayList<>(roles);
    }

    public ArrayList<Account> getAllAccountsWithRole(String roleName){
        for(Role role : roles){
            if(role.getName().contentEquals(roleName)){
                return new ArrayList<>(role.getAccountsWithThisRole());
            }
        }
        return null;
    }
}
