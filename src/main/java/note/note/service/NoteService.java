package note.note.service;

import note.note.dao.CategoryDao;
import note.note.dao.NoteDao;
import note.note.dao.UserDao;
import note.note.entity.Note;
import note.note.entity.Tag;
import note.note.entity.User;
import note.note.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("NoteService")
public class NoteService {
    private final UserDao userDao;

    private final CategoryDao categoryDao;

    private final NoteDao noteDao;
    @Autowired
    private UserService userService;
    public NoteService(NoteDao noteDao, CategoryDao categoryDao, UserDao userDao) {
        this.noteDao = noteDao;
        this.categoryDao = categoryDao;
        this.userDao = userDao;
    }

    public Note getNoteById (int id ){
        return noteDao.getNoteById(id);
    }

    public void saveNote(int uId, int catId, String title, String body){
       /* Note tmp = new Note();
        tmp.setTitle(title);
        tmp.setBody(body);
        tmp.setCategory(categoryDao.getCategoryById(catId));
        tmp.setOwner(userDao.getUserById(uId));
        noteDao.saveNote(tmp);*/

       Note tmp=new Note();
       tmp.setTitle(title);
       tmp.setBody(body);
       tmp.setCategory(categoryDao.getCategoryById(catId));
       tmp.setOwner(userDao.getUserById(uId));
       noteDao.saveNote(tmp);


    }

    public List<Note> getNoteList(int uId){
        return noteDao.getNoteList(userDao.getUserById(uId));
    }

    public void deleteNote(int noteId){
        /*Note tmpNote = new Note();
        tmpNote = noteDao.getNoteById(noteId);
        noteDao.deleteNote(tmpNote);*/

        Note tmpNote=new Note();
        tmpNote=noteDao.getNoteById(noteId);
        noteDao.deleteNote(tmpNote);

    }

    public void updateNote(int id, String title , int catId , String body){
       /* Note tmp = new Note();
        tmp = noteDao.getNoteById(id);
        tmp.setTitle(title);
        tmp.setCategory(categoryDao.getCategoryById(catId));
        tmp.setBody(body);*/

       Note temp=new Note();
       temp.setTitle(title);
       temp.setBody(body);
       temp.setCategory(categoryDao.getCategoryById(catId));
       temp=noteDao.getNoteById(id);


    }
}

