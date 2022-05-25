package spring.website.supermarket.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Staff {

    @Id
    @Column(nullable = false, length = 5)
    private String staff_id;

    @Column(nullable = false, length = 20)
    private String staff_fname;

    @Column(nullable = false, length = 20)
    private String staff_lname;

    @Column(nullable = false, length = 20)
    private String staff_position;

    @Email
    @Column(nullable = false, length = 50)
    private String staff_email;

    @Column(nullable = false, length = 8)
    private String staff_pass;

    public String getStaff_pass() {
        return staff_pass;
    }

    public void setStaff_pass(String staff_pass) {
        this.staff_pass = staff_pass;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_fname() {
        return staff_fname;
    }

    public void setStaff_fname(String staff_fname) {
        this.staff_fname = staff_fname;
    }

    public String getStaff_lname() {
        return staff_lname;
    }

    public void setStaff_lname(String staff_lname) {
        this.staff_lname = staff_lname;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }
}

