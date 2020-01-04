package note.note.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cat_id;

    private String title;


    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;



    public Category(int cat_id, String title, User owner) {
        this.cat_id=cat_id;
        this.title = title;
        this.owner = owner;
    }

    public Category() {

    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
