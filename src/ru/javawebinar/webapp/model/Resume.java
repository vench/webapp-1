package ru.javawebinar.webapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * GKislin
 * 29.03.2016
 */
public class Resume {
    private String fullName;
    private String about;
    private List<Contact> contacts = new ArrayList<>();
    private List<Section> sections = new ArrayList<>();

    public Resume(String fullName, String about) {
        this.fullName = fullName;
        this.about = about;
    }

    public void addContact(ContactType type, String value) {
        contacts.add(new Contact(type, value));
    }

    public void addSection(Section section) {
        sections.add(section);
    }
}
