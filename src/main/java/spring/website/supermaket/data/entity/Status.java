package spring.website.supermaket.data.entity;

import javax.persistence.Entity;

import spring.website.supermaket.data.AbstractEntity;

@Entity
public class Status extends AbstractEntity {
    private String name;

    public Status() { }

    public Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
