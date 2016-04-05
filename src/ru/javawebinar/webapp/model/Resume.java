package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 29.03.2016
 */
public class Resume {
    public Resume(String fullName, String about) {
        this.fullName = fullName;
        this.about = about;
    }

    private String fullName;
    private String about;
    private List<Contact> contacts;
    private List<Section> sections;
}
