package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String priority;
    @NotNull
    private String duedate;
    @NotNull
    private String iscompleted;

    public Item(@NotNull String name, @NotNull String description, @NotNull String priority, @NotNull String duedate, @NotNull String iscompleted) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.duedate = duedate;
        this.iscompleted = iscompleted;
    }

    public Item() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getIscompleted() {
        return iscompleted;
    }

    public void setIscompleted(String iscompleted) {
        this.iscompleted = iscompleted;
    }
}
