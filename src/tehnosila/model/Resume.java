package tehnosila.model;

import tehnosila.model.section.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vench on 30.03.16.
 */
public class Resume extends Model {

    public String fullname;
    public String address;
    public String about;

    public List<Contact> phones;
    public List<Contact> contacts;
    public List<Contact> links;


    /**
     * Секции
     */
    public List<Section> sections;

    public void init() {

        contacts = new ArrayList<>();
        phones = new ArrayList<>();
        links = new ArrayList<>();

        sections = new ArrayList<>();
        sections.add( new ObjectiveSection());
        sections.add( new AchievementSection());
        sections.add( new QualificationsSection());
        sections.add( new ExperienceSection());
        sections.add( new EducationSection());

    }

}
