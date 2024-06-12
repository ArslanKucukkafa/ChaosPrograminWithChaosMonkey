package com.ozguryazilim.telve.boot.ymgkchaos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
    @Column(name = "published")
    private boolean published;


    public Projects() {}

    public Projects(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public boolean getPublished() {
        return published;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }

}
