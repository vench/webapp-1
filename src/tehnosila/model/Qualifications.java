package tehnosila.model;


import java.util.List;


/**
 * Created by vench on 30.03.16.
 * Квалификация
 */
public class Qualifications  extends Model {
    public String title;
    public String description;

    /**
     * Вложенные элемент, нужны ли?
     */
    public List<Qualifications> childrens;


}
