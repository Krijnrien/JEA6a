package dao.Implementation;

import dao.JPA;
import dao.IRoleDao;
import domain.Account;
import domain.Role;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@JPA
public class RoleDao extends DaoManager<Role> implements IRoleDao {

    public List<Role> getAccountsWithRole(String RoleName) {
        TypedQuery<Role> query = em.createNamedQuery("role.accountsWithRole", Role.class);
        query.setParameter("name", RoleName);
        return query.getResultList();
    }

    public void addAccountToRole(Account account, Role role){
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(account);
        role.setAccountsWithThisRole(accounts);
        em.persist(role);
        account.setRole(role);
        em.persist(account);
    }

    public ArrayList<Role> getAllORoles() {
        Query query = em.createQuery("SELECT a FROM Role a");
        return new ArrayList<>(query.getResultList());
    }
}
