package tehnosila.model;

/**
 * Created by vench on 30.03.16.
 */
public  class Contact extends Model {

    public enum Type {
        URL,
        EMAIL,
        PHONE,
        SKYPE,
        HABARHABR,
        STACK_OVERFLOW,
        GITHUB,
        TEXT
    };

    public Contact.Type type;
    public String value;


    public Contact() {}

    public Contact(Contact.Type type, String value) {
        this.type = type;
        this.value = value;
    }
}
