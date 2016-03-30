package tehnosila.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by vench on 30.03.16.
 * Позиция
 */
public class Objective {


    private List<Achievement> achievements;

    private List<Experience> experiences;

    private List<Education> educations;


    private Qualifications qualifications;

    public Objective() {
        achievements = new ArrayList<>();
    }

    public void addAchievement(Achievement achievement ) {
        achievements.add(achievement);
    }

    public Qualifications getQualifications() {
        return qualifications;
    }

    public void setQualifications(Qualifications qualifications) {
        this.qualifications = qualifications;
    }

    public void addExperience(Experience experience ) {
        experiences.add(experience);
    }

    public void addEducation(Education education ) {
        educations.add(education);
    }


}
