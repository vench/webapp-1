package main;

import org.omg.CORBA.SystemException;
import ru.javawebinar.webapp.model.*;
import ru.javawebinar.webapp.storage.ArrayStorageImpl;
import ru.javawebinar.webapp.storage.SortedArrayStorageImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * GKislin
 * 05.04.2016
 */
public class MainArrayStorage {

    public static void main(String[] args) {



        ArrayStorageImpl asi = new ArrayStorageImpl();
        asi.clear();

        try {


            asi.save(newResume("A"));
            asi.save(newResume("B"));
            asi.save(newResume("C"));
            asi.save(newResume("D"));
            asi.save(newResume("E"));

            Resume x = newResume("Delete");
            asi.save(x);
            asi.delete(x.getUuid());

        }   catch (Exception e) {
            System.out.println(e.getMessage());
        }


        SortedArrayStorageImpl sasl = new SortedArrayStorageImpl();
        try {
            for(int i = 0; i  < 1000; i ++) {
                sasl.save( newResume("A" + i) );
            }
            System.out.println(sasl.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println( (double)41 / 2);
    }




    public static Resume newResume(String postfix) {
        Resume r1 = new Resume("Полное Имя1" + postfix, "About1" + postfix);
        r1.addContact(ContactType.MAIL, "mail1@ya.ru" + postfix);
        r1.addContact(ContactType.PHONE, "11111" + postfix);
        r1.addSection(new TextSection(SectionType.OBJECTIVE, "Objective1" + postfix));
        r1.addSection(new ListSection(SectionType.ACHIEVEMENT, "Achivment11" + postfix, "Achivment12" + postfix, "Achivment12" + postfix));
        r1.addSection(new ListSection(SectionType.QUALIFICATIONS, "Java", "SQL"));
        r1.addSection(new OrganizationSection(SectionType.EXPERIENCE, Arrays.asList(
                new Organization(new Link(), Arrays.asList(
                        new Position(new Date(), new Date(), "Title1" + postfix, "Descript1" + postfix),
                        new Position(new Date(), new Date(), "Title2" + postfix, "Descript2" + postfix)
                ))
        )));
        r1.addSection(new OrganizationSection(SectionType.EDUCATION, Arrays.asList(
                new Organization(new Link(), Arrays.asList(
                        new Position(new Date(), new Date(), "Title1" + postfix, "Descript1" + postfix),
                        new Position(new Date(), new Date(), "Title2" + postfix, "Descript2" + postfix)
                )),
                new Organization(new Link(), Arrays.asList(
                        new Position(new Date(), new Date(), "Title3" + postfix, "Descript3" + postfix),
                        new Position(new Date(), new Date(), "Title4" + postfix, "Descript4" + postfix)
                ))
        )));

        return r1;
    }
}
