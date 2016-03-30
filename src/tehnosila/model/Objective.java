package tehnosila.model;



/**
 * Created by vench on 30.03.16.
 * Позиция
 */
public class Objective implements IHtmlViewer, IActiveModel {


    public String title;


    @Override
    public String toHtml() {
        return "<b><" + title + "/b>";
    }

    @Override
    public void save(IActiveModelStore store) {

    }

    @Override
    public void delete(IActiveModelStore store) {

    }


}
