package dao;

import domain.User;

import java.util.concurrent.CopyOnWriteArrayList;

public class UserDao {

    CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        for(User userOfList : users){
            if(userOfList.getUsername().contentEquals(user.getUsername())){
                users.remove(user);
            }
        }
    }

    public User findUserByName(String userName){
        for(User user : users){
            if(user.getUsername().contentEquals(userName)){
                return user;
            }
        }
        return null;
    }
}
