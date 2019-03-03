package dao;

import domain.User;

import java.util.ArrayList;

public interface IUserDao extends IDaoManager<User> {

    User findUserByName(String userName);

    ArrayList<User> getAllUsers();

    User findByCredentials(String username, String password);
}
