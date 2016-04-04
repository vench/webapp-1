package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public class TextSection extends Section {
    private String content;

    public TextSection(Section.Type type,  String content) {
        super(type);
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
