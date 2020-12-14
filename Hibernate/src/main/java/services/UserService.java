package services;

import dao.UserDao;
import models.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public void saveUser(User user){
        userDao.save(user);
    }

    public User findUser(int id){
        return userDao.findById(id);
    }
}
