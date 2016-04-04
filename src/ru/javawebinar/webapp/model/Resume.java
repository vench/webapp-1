package ru.javawebinar.webapp.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * GKislin
 * 29.03.2016
 */
public class Resume {


    private String fullName;
    private String about;
    private List<Contact> contacts;
    private List<Section> sections;


    public Resume() {

    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Contact getContactByType(Contact.Type type) {
        for(Contact c : contacts) {
            if(c.getType().equals(type)) {
                return c;
            }
        }
        return null;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Section getSectionByType(Section.Type type) {
        for(Section s : sections) {
            if(s.getType().equals(type)) {
                return s;
            }
        }
        return  null;
    }
}
