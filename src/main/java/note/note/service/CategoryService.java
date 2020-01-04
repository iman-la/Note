package note.note.service;

import note.note.dao.CategoryDao;
import note.note.dao.UserDao;
import note.note.entity.Category;
import note.note.entity.User;
import note.note.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoryService")
public class CategoryService {

    private final CategoryDao categoryDao;
    private final UserDao userDao;

    public CategoryService(CategoryDao categoryDao, UserDao userDao) {
        this.categoryDao = categoryDao;
        this.userDao = userDao;
    }

    public void newCategory(String title, User ownerUserObj) {

       Category catObj = new Category(1,title,ownerUserObj);
        categoryDao.newCategory(catObj);
    }

    public List<Category> getCategories(int uId){
    return categoryDao.getCategories(userDao.getUserById(uId));
    }

    public void saveCategory (String title){
        Category tmp = new Category();
        tmp.setTitle(title);
        tmp.setOwner(userDao.getUserByEmail(UserUtils.getCurrentLoggedInUser()));
        categoryDao.saveCategory(tmp);
    }

    public void deleteCategory(int id){
        Category category = new Category();
        categoryDao.deleteCategory(categoryDao.getCategoryById(id));
    }
}
