package tehnosila.model;

/**
 * Created by vench on 30.03.16.
 * Компания
 */
public class Company implements IHtmlViewer,IActiveModel {
    public String name;
    public String url;

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
