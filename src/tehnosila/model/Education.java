package tehnosila.model;

import java.util.Date;

/**
 * Created by vench on 30.03.16.
 * Образование
 */
public class Education implements IHtmlViewer , IActiveModel{

    public Institution institution;
    public Date dateStart;
    public Date dateEnd;
    public String description;

    @Override
    public String toHtml() {
        return null;
    }

    @Override
    public void save(IActiveModelStore store) {

    }

    @Override
    public void delete(IActiveModelStore store) {

    }
}
