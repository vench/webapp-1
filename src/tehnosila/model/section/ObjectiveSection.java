package tehnosila.model.section;

import tehnosila.model.Objective;

import java.util.List;

/**
 * Created by vench on 31.03.16.
 * Список позиций соискателя
 */
public class ObjectiveSection extends Section{
    public List<Objective> list;

    public ObjectiveSection() {
        name = "Позиции";
    }
}
