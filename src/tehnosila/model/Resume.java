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


    /**
     * Секции
     */
    public List<Section> sections;

    public void init() {
        sections = new ArrayList<>();
        sections.add( new ContactSection());
        sections.add( new ObjectiveSection());
        sections.add( new AchievementSection());
        sections.add( new ExperienceSection());
        sections.add( new EducationSection());
        sections.add( new QualificationsSection());
    }
}
