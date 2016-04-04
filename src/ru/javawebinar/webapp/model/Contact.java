package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public class Contact {

    public enum Type {
        EMAIL,
        PHONE,
        SKYPE
    }

    private Contact.Type type;
    private String value;

    public Contact(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Contact(type: " + type + ", value: " + value +")";
    }
}
