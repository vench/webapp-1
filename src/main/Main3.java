package main;

import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.Resume;

/**
 * GKislin
 * 05.04.2016
 */
public class Main3 {
    public static void main(String[] args) {
        Resume r1 = new Resume("Полное Имя1", "About1");
        ContactType contactType = ContactType.HOME_PAGE;

        String name = contactType.name();
        ContactType contactType2 = ContactType.valueOf(name);
        Class<ContactType> enumClass = ContactType.class;

        Enum ct = Enum.valueOf(enumClass, name);
        System.out.println(ct == contactType2);
        System.out.printf("" + contactType);
    }
}
