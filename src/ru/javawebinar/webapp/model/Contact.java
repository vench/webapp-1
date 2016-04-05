package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public class Contact {
    private final ContactType type;
    private String value;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }
}
