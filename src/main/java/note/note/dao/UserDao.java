package note.note.dao;

import note.note.entity.User;
import note.note.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDao")
public class UserDao {

    private Session currentSession;

    public UserDao() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
    }

    public User getUserById(int uid) {
        return currentSession.get(User.class, uid);
    }

    public User getUserByEmail(String email) {
        User a = new User();
        List<User> list = currentSession
                .createQuery("from User where email=:inputEmail")
                .setParameter("inputEmail", email)
                .list();

        if (!list.isEmpty()) {
            a = list.get(0);
        }
        return a;
    }


}
