package tehnosila.model;

/**
 * Created by vench on 30.03.16.
 * Достижения
 */
public class Achievement implements IHtmlViewer, IActiveModel {
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
