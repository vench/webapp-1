package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public class TextSection extends Section {
    private String content;

    public TextSection(String content) {
        super("TextSection");
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextSection(content: " + content+")";
    }
}
