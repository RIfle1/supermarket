package spring.website.supermarket.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class User {

    @Id
    @Column(nullable = false, length = 5)
    private int user_id;

    @Column(nullable = false, length = 20)
    private String user_fname;

    @Column(nullable = false, length = 20)
    private String user_lname;

    @Email
    @Column(nullable = false, length = 50)
    private String user_email;

    @Column(nullable = false, length = 8)
    private String user_pass;

    public String getUser_fname() {
        return user_fname;
    }
    public void setUser_fname(String user_fname) {
        this.user_fname = user_fname;
    }
    public String getUser_lname() {
        return user_lname;
    }
    public void setUser_lname(String user_lname) {
        this.user_lname = user_lname;
    }
    public String getUser_pass() {
        return user_pass;
    }
    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getUser_name() {
        return user_fname;
    }
    public void setUser_name(String user_name) {
        this.user_fname = user_name;
    }
    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

}
