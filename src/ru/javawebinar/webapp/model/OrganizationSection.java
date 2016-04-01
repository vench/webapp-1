package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class OrganizationSection extends Section {
    public OrganizationSection(List<Organization> organizations) {
        this.organizations = organizations;
    }

    private List<Organization> organizations;
}
