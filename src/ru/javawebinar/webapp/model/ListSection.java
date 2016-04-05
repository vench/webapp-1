package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class ListSection extends Section {
    private List<String> lines;

    public ListSection() {
        super("ListSection");
    }

    public ListSection( List<String> lines) {
        this();
        this.lines = lines;
    }

    public void setLines( List<String> lines) {
        this.lines = lines;
    }


    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for(String s : lines) {
            str.append(s);
            str.append(",");
        }
        return "ListSection(type:" + getType() +", " + str.toString()   + ")";
    }
}
