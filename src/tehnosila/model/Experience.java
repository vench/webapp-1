package tehnosila.model;


import java.util.Date;

/**
 * Created by vench on 30.03.16.
 * Опыт работы
 */
public class Experience implements IHtmlViewer, IActiveModel {
    public Company company;
    public Objective objective;
    public String description;
    public Date dateStart;
    public Date dateEnd;

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
