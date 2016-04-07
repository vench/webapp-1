package ru.javawebinar.webapp.model;

import java.util.Date;

/**
 * GKislin
 * 01.04.2016
 */
public class Position {
    private Date startDate;
    private Date endDate;
    private String title;
    private String description;


    public Position(Date startDate, Date endDate, String title, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }
}
