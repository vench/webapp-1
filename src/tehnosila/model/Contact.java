package tehnosila.model;

/**
 * Created by vench on 30.03.16.
 */
public  class Contact extends Model {

    public enum types {
        EMAIL,
        PHONE,
        SKYPE
    };

    public String type;
    public String source;
}
