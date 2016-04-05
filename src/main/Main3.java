package main;

import ru.javawebinar.webapp.model.*;

/**
 * GKislin
 * 05.04.2016
 */
public class Main3 {
    public static void main(String[] args) {
        ContactType contactType = ContactType.HOME_PAGE;

        String name = contactType.name();
        ContactType contactType2 = ContactType.valueOf(name);
        Class<ContactType> enumClass = ContactType.class;

        Enum ct = Enum.valueOf(enumClass, name);
        System.out.println(ct == contactType2);
        System.out.printf("" + contactType);

        Resume r1 = new Resume("Полное Имя1", "About1");
        r1.addContact(ContactType.MAIL, "mail1@ya.ru");
        r1.addContact(ContactType.PHONE, "11111");
        r1.addSection(new TextSection(SectionType.OBJECTIVE, "Objective1"));
        r1.addSection(new ListSection(SectionType.ACHIEVEMENT, "Achivment11", "Achivment12", "Achivment12"));
        r1.addSection(new ListSection(SectionType.QUALIFICATIONS, "Java", "SQL"));

        System.out.println(r1.toString());

        char ch2 = 'A';
        System.out.println(ch2);


        String s = "Hello WebApp";
        System.out.println(s.charAt(5));
        System.out.println(s.substring(2, 5));

        String s2 = new String("Hello " + "WebApp");
        System.out.println(s == s2);

    }
}
