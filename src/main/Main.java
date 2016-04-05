package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import ru.javawebinar.webapp.model.*;

/**
 * User: gkislin
 * Date: 18.06.2014
 */
public class Main {
    /**
     * First java program
     *
     * @param args : program arguments
     */
    public static void main(String[] args) {

        //init Resume
        Resume r = new Resume();
        r.setAbout("Информация о себе!!!");
        r.setFullName("Иванов Иван Иванович");
        r.setContacts( Arrays.asList(
                new Contact(Contact.Type.EMAIL, "Nowwrit@gmail.com"),
                new Contact(Contact.Type.PHONE, "8-812-654-1212"),
                new Contact(Contact.Type.SKYPE, "ben66542")
        ));

        Map<SectionType, Section> sections = SectionType.instanceAll();
        TextSection o = (TextSection)sections.get(SectionType.OBJECTIVE);
        o.setContent("PHP, HTML, JAVA, MAVEN & etc");
        r.setSections(sections);
        //end init Resume

        Contact c = r.getContactByType(Contact.Type.EMAIL);
        System.out.println(c);

        o = (TextSection)r.getSectionByType(SectionType.OBJECTIVE);
        System.out.println(o);
    }
}
