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
        GITHUB
    };

    public Contact.Type type;
    public String source;


    public Contact() {}

    public Contact(Contact.Type type, String source) {
        this.type = type;
        this.source = source;
    }
}
