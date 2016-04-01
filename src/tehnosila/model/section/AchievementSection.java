package tehnosila.model.section;

import java.util.ArrayList;
import java.util.List;

import tehnosila.model.Achievement;

/**
 * Created by vench on 31.03.16.
 */
public class AchievementSection extends Section {


    public List<Achievement> list;

    public AchievementSection() {
        name = "Достижения";
        list = new ArrayList<>();
    }
}
