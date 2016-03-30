package tehnosila.model;

/**
 * Created by vench on 30.03.16.
 * Ссылка
 */
public class Link implements IHtmlViewer, IActiveModel {
    public String url;
    public String name;

    @Override
    public String toHtml() {
        return "<a href=\"" + url+ "\">" +  name + "</a>";
    }

    @Override
    public void save(IActiveModelStore store) {

    }

    @Override
    public void delete(IActiveModelStore store) {

    }
}
