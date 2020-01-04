package note.note.controller;

import note.note.entity.Category;
import note.note.entity.Note;
import note.note.entity.Tag;
import note.note.entity.User;
import note.note.service.CategoryService;
import note.note.service.UserService;
import note.note.util.HibernateUtil;
import note.note.util.UserUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final UserService userService;
    private final CategoryService categoryService;

    public CategoryController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String showCategories(Model m) {
        List<Category> categories = categoryService.getCategories(userService.getCurrentUserId());
        m.addAttribute("categories", categories);
        return "main/category_list";
    }

    @GetMapping("/new_category")
    public String newCategory() {
        return "main/new_category";
    }

    @PostMapping("/save_category")
    public String saveCategory(@RequestParam("title") String title) {
        categoryService.saveCategory(title);
        return "redirect:/category";
    }

    @PostMapping("/delete_category")
    public String deleteCategory(@RequestParam("catId") String id) {
        categoryService.deleteCategory(Integer.parseInt(id));
        return "redirect:/category";
    }
}
