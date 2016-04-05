package main;

import ru.javawebinar.webapp.model.*;

/**
 * GKislin
 * 05.04.2016
 */
public class MainArrayStorage {
    // TODO add OrganizationSection
    public static void main(String[] args) {
        Resume r1 = new Resume("Полное Имя1", "About1");
        r1.addContact(ContactType.MAIL, "mail1@ya.ru");
        r1.addContact(ContactType.PHONE, "11111");
        r1.addSection(new TextSection(SectionType.OBJECTIVE, "Objective1"));
        r1.addSection(new ListSection(SectionType.ACHIEVEMENT, "Achivment11", "Achivment12", "Achivment12"));
        r1.addSection(new ListSection(SectionType.QUALIFICATIONS, "Java", "SQL"));

        // TODO test ArrayStorageImpl
    }
}
