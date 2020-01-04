package note.note.service;

import note.note.dao.UserDao;
import note.note.entity.User;
import note.note.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(int uid) {
        return userDao.getUserById(uid);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
    public int getCurrentUserId(){
        return getUserByEmail(UserUtils.getCurrentLoggedInUser()).getUser_id();
    }
    public User getCurrentUser(){
        return getUserByEmail(UserUtils.getCurrentLoggedInUser());
    }


}
