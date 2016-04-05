package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class ListSection extends Section {
    private List<String> lines;

    public ListSection(SectionType type, String... lines) {
        super(type);
        System.out.println();
    }

    public ListSection(SectionType type, List<String> lines) {
        super(type);
        this.lines = lines;
    }
}
