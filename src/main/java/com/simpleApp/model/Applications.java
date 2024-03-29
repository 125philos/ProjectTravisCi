package com.simpleApp.model;

import javax.persistence.*;

@Entity
@Table(name = "application_table")
public class Applications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_application")
    private String nameApplication;

    @Column(name = "previous_Application")
    private String previousApplication;

    @Column(name = "next_Application")
    private String nextApplication;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameApplication() {
        return nameApplication;
    }

    public void setNameApplication(String nameApplication) {
        this.nameApplication = nameApplication;
    }

    public String getPreviousApplication() {
        return previousApplication;
    }

    public void setPreviousApplication(String previousApplication) {
        this.previousApplication = previousApplication;
    }

    public String getNextApplication() {
        return nextApplication;
    }

    public void setNextApplication(String nextApplication) {
        this.nextApplication = nextApplication;
    }

    @Override
    public String toString() {
        return "Applications [nameApplication=" + nameApplication + ", previousApplication=" + previousApplication + ", nextApplication=" + nextApplication + "]";
    }
}
