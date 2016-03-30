package tehnosila.model;

/**
 * Created by vench on 30.03.16.
 * учебное заведение
 */
public class Institution implements IHtmlViewer, IActiveModel {
    public String name;

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
