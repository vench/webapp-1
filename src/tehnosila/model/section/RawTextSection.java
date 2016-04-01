package tehnosila.model.section;

import java.util.List;

import tehnosila.model.RawText;

/**
 * Created by vench on 01.04.16.
 */
public class RawTextSection extends Section {
    public List<RawText> list;

    public RawTextSection(String name) {
        this.name = name;
    }
}
