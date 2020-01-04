package note.note.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "tbl_user_note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int note_id;

    private String title;

    @Lob
    private String body;


    @ManyToMany(mappedBy = "noteList")
    private List<Tag> tagList;

    @ManyToMany(mappedBy = "noteList")
    private List<User> userList;

    @ManyToOne
    private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category ;

    public Note() {
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
