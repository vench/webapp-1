package ru.javawebinar.webapp.model;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by vench on 05.04.16.
 *
 * @// TODO: 05.04.16 Конечно тут можно добавить и другие атрибуты при инициализации  Section
 */
public enum SectionType {



    OBJECTIVE { public Section newInstance() { return new TextSection(""); }; },
    ACHIEVEMENT { public Section newInstance() { return new ListSection(); }; },
    QUALIFICATIONS { public Section newInstance() { return new ListSection(); }; },
    EXPERIENCE { public Section newInstance() { return new OrganizationSection(); }; },
    EDUCATION { public Section newInstance() { return new OrganizationSection(); }; };


    public abstract Section newInstance();


    public static Map<SectionType, Section> instanceAll() {
        Map<SectionType, Section> map = new HashMap<>();
        for(SectionType type : SectionType.values()) {
            map.put(type, type.newInstance());
        }

        return map;
    }
}
