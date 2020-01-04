package note.note.dao;

import note.note.entity.Category;
import note.note.entity.User;
import note.note.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("CategoryDao")
public class CategoryDao {

    private Session currentSession;

    public CategoryDao() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
    }

    public void newCategory(Category catObj){
        Transaction transaction = currentSession.beginTransaction();
        currentSession.save(catObj);
        transaction.commit();
    }

    public List<Category> getCategories(User owner) {
        List<Category> categories;
        Query q = currentSession.createQuery("from Category where owner=:owner");
        q.setParameter("owner",owner);
        categories = (List<Category>) q.list();
        return categories;
    }

    public Category getCategoryById(int id){
        return currentSession.load(Category.class,id);
    }

    public void saveCategory(Category tmp){
        Transaction tx = currentSession.beginTransaction();
        currentSession.save(tmp);
        tx.commit();
    }

    public void deleteCategory(Category tmp){
        Transaction tx = currentSession.getTransaction();
        currentSession.delete(tmp);
        tx.commit();
    }
}
