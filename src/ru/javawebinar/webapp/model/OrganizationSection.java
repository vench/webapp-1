package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class OrganizationSection extends Section {

    private List<Organization> organizations;

    public OrganizationSection(SectionType type, List<Organization> organizations) {
        super(type);
        this.organizations = organizations;
    }
}
