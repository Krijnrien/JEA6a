package JPA;

import dao.Implementation.AccountDao;
import domain.Account;
import domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class AccountDaoTest {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("KwetterTestPU");
    private EntityTransaction tx;

    private AccountDao accountDao;
    private Account account;

    @Before
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        tx = em.getTransaction();

        this.accountDao = new AccountDao();
        accountDao.setEm(em);

        User userOne = new User("Vamana", "123", "vaman@hotmail.com");
        account = new Account(userOne, null, null, "Eindhovski", "Български");
    }

    @Test
    public void create_ClassType_TypeCreated() {
        tx.begin();
        accountDao.add(account);
        tx.commit();

        tx.begin();
        List<Account> accounts = accountDao.getAllAccounts();
        tx.commit();

        Assert.assertEquals(1, accounts.size());
        Assert.assertNotEquals(2, accounts.size());
    }
}
