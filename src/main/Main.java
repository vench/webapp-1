package main;

import java.util.Arrays;
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

        Resume r = new Resume();
        r.setAbout("Информация о себе!!!");
        r.setFullName("Иванов Иван Иванович");
        r.setContacts( Arrays.asList(
                new Contact(Contact.Type.EMAIL, "Nowwrit@gmail.com"),
                new Contact(Contact.Type.PHONE, "8-812-654-1212"),
                new Contact(Contact.Type.SKYPE, "ben66542")
        ));
        r.setSections(Arrays.asList(
                (Section) (new OrganizationSection(
                        Arrays.asList(
                                new Organization(),
                                new Organization()
                        )
                )),
                (Section) (new ListSection(Section.Type.Objective,
                        Arrays.asList(
                                "PHP", "Java", "Css", "C++"
                        )
                ))
        ));




        Contact c = r.getContactByType(Contact.Type.EMAIL);
        System.out.println(c);

        ListSection o = (ListSection)r.getSectionByType(Section.Type.Objective);
        System.out.println(o);
    }
}
