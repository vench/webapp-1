package tehnosila.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vench on 30.03.16.
 */
public class Resume implements IHtmlViewer, IActiveModel {

    public String email;
    public String name;
    public String surname;
    public String patronymic;
    public String phone;
    public String address;
    public String about;


    /**
     * ССылки на соц сети и тп
     */
    public List<Link> links;

    /**
     * Можем искать сразу несколько
     */
    public List<Objective> objectives;

    /**
     * Достижения
     */
    public List<Achievement> achievements;

    /**
     * Опыт работы
     */
    public List<Experience> experiences;

    /**
     * Образование
     */
    public List<Education> educations;

    /**
     * Квалификация
     */
    public List<Qualifications> qualifications;


    public String getFullName() {
        return (name + " " + patronymic + " " + surname).trim();
    }


    @Override
    public String toHtml() {
        String html = "";
        html += "<h1>" + getFullName() + "</h1>";


        return html;
    }

    @Override
    public void save(IActiveModelStore store) {

    }

    @Override
    public void delete(IActiveModelStore store) {

    }
}
