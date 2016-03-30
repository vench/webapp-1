package tehnosila.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vench on 30.03.16.
 */
public class Resume extends Model {

    public String email;
    public String fullname;
    public String address;
    public String about;


    /**
     * Телефоны
     */
    public List<Phone> phones;

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




}
