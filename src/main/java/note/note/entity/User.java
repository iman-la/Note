package note.note.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    private String password;
    private String email;
    private String firstName;
    private String lastName;


    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Category> categoryListOwnedBy;

    @ManyToMany
    private List<Note> noteList;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Category> getCategoryListOwnedBy() {
        return categoryListOwnedBy;
    }

    public void setCategoryListOwnedBy(List<Category> categoryListOwnedBy) {
        this.categoryListOwnedBy = categoryListOwnedBy;
    }
}
