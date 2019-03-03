package dao;

import domain.Account;
import domain.Role;

import java.util.ArrayList;
import java.util.List;

public interface IRoleDao extends IDaoManager<Role> {

    List<Role> getAccountsWithRole(String RoleName);

    void addAccountToRole(Account account, Role role);

    ArrayList<Role> getAllORoles();
}
