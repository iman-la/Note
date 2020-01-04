package note.note.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_user_tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tag_id;

    private String title;

    @ManyToMany
    private List<Note> noteList;

    public int getTag_id() {
        return tag_id;
    }

    public Tag() {
    }


    public void setTag_id(int id) {
        this.tag_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }
}
