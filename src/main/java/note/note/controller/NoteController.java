package note.note.controller;

import note.note.entity.Category;
import note.note.entity.Note;
import note.note.entity.User;
import note.note.service.CategoryService;
import note.note.service.NoteService;
import note.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;
    private final CategoryService categoryService;

    private final UserService userService;

    public NoteController(NoteService noteService, CategoryService categoryService, UserService userService) {
        this.noteService = noteService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("")
    public String getNoteList(Model m) {
        List<Note> noteList = new ArrayList<>();
        noteList = noteService.getNoteList(userService.getCurrentUserId());
        m.addAttribute("notes", noteList);
        return "main/note_list";
    }

    @GetMapping("/new_note")
    public String newNote(Model m) {
        List<Category> categories;
        categories = categoryService.getCategories(userService.getCurrentUserId());
        m.addAttribute("categories", categories);
        return "main/new_note";
    }


    @PostMapping("/save_note")
    public String saveNote(@RequestParam("title") String title,
                           @RequestParam("body") String body,
                           @RequestParam("uId") String uId,
                           @RequestParam("catId") String catId) {
        int uid = Integer.parseInt(uId);
        int catid = Integer.parseInt(catId);
        System.out.println(title + body + uid + catid);
        noteService.saveNote(uid, catid, title, body);
        return "redirect:/note";
    }
    @PostMapping("/delete_note")
    public String deleteNote(@RequestParam("noteId")String id,
                             Model m){
        int noteId = Integer.parseInt(id);
        noteService.deleteNote(noteId);
        return "redirect:/note";
    }


    @PostMapping("update_note_form")
    public String updateNoteForm(@RequestParam("noteId") String id,
                                 Model m)
    {
        List<Category> categories;
        categories = categoryService.getCategories(userService.getCurrentUserId());
        m.addAttribute("categories", categories);
        int noteId = Integer.parseInt(id);
        Note tmp = noteService.getNoteById(noteId);
        m.addAttribute("PLnote",tmp);
        m.addAttribute("cat",categories);
        return "main/note_update_form";
    }

    @PostMapping("/update_note")
    public String updateNote(@RequestParam("noteId") String id,
                             @RequestParam("title") String title,
                             @RequestParam("body") String body,
                             @RequestParam("catId") String catId,
                             Model m) {
       int noteId = Integer.parseInt(id);
       int tmpCatId = Integer.parseInt(catId);
       noteService.updateNote(noteId,title,tmpCatId,body);
        List<Note> noteList = new ArrayList<>();
        noteList = noteService.getNoteList(userService.getCurrentUserId());
        m.addAttribute("notes", noteList);
       return "redirect:/note";
    }
}
