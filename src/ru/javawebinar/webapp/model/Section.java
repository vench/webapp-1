package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public abstract class Section {
    private final SectionType type;

    public Section(SectionType type) {
        this.type = type;
    }
}
