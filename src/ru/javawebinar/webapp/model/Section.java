package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public abstract class Section {


    public enum Type {
        Objective,
        Organization
    }

    private Section.Type type;

    protected Section(Section.Type type) {
        this.type = type;
    }


    public Type getType() {
        return type;
    }

}
