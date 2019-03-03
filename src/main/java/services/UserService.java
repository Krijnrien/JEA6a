package services;

import com.mysql.jdbc.StringUtils;
import dao.IAccountDao;
import dao.IUserDao;
import dao.JPA;
import domain.User;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserService {

    @Inject
    @JPA
    private IUserDao userDao;

    public UserService() {
    }

    public UserService(IAccountDao accountDao) {
    }

    public User create(User user) {
        return this.userDao.add(user);
    }

    public void remove(User user) {
        this.userDao.delete(user);
    }

    public User findByName(String username) {
        User user = this.userDao.findUserByName(username);
        return user;
    }

    public User findByCredentials(String username, String password) {
        if (!StringUtils.isNullOrEmpty(username) && !StringUtils.isNullOrEmpty(password)) {
            return this.userDao.findByCredentials(username, password);
        }
        return null;
    }
}
