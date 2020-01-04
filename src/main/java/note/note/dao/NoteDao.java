package note.note.dao;

import note.note.entity.Note;
import note.note.entity.User;
import note.note.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("NoteDao")
public class NoteDao {
    Session currentSession;


    public NoteDao() {
        currentSession= HibernateUtil.getSessionFactory().openSession();
    }

    public Note getNoteById(int id){
        return currentSession.get(Note.class,id);
    }

    public void saveNote(Note tempNote){
        Transaction tx = currentSession.beginTransaction();
        currentSession.save(tempNote);
        tx.commit();
    }
    public List<Note> getNoteList(User tmp){
        Query q = currentSession.createQuery("From Note where owner =:user");
        q.setParameter("user", tmp);
        List<Note> noteList = new ArrayList<>();
        noteList =  (List<Note>) q.list();
        return noteList;
    }

    public void deleteNote(Note tmp){
        Transaction transaction=currentSession.beginTransaction();
        currentSession.delete(tmp);
        transaction.commit();
    }
    public void updateNote(Note tmp){
        Transaction tx =currentSession.beginTransaction();
        currentSession.update(tmp);
        tx.commit();

    }
}
