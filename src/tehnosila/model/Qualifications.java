package tehnosila.model;


import java.util.List;


/**
 * Created by vench on 30.03.16.
 * Квалификация
 */
public class Qualifications implements IHtmlViewer, IActiveModel {
    public String title;
    public String description;

    /**
     * Вложенные элемент, нужны ли?
     */
    public List<Qualifications> childrens;

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
