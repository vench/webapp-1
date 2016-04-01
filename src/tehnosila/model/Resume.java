package tehnosila.model;

import tehnosila.model.section.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vench on 30.03.16.
 */
public class Resume extends Model {

    public String fullname;
    public String about;

    public List<Contact> contacts;

    /**
     * Секции
     */
    public List<Section> sections;

    public void init() {

        contacts = new ArrayList<>();

        sections = new ArrayList<>();
        sections.add( new RawTextSection("Позиции"));
        sections.add( new RawTextSection("Достижения"));
        sections.add( new RawTextSection("Квалификация"));
        sections.add( new ExperienceSection());
        sections.add( new EducationSection());

    }

}
