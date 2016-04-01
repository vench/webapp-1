package main;



import tehnosila.model.*;
import tehnosila.model.section.*;

/**
 * User: gkislin
 * Date: 18.06.2014
 */
public class Main {
    /**
     * First java program
     *
     * @param args : program arguments
     */
    public static void main(String[] args) {

        Resume r = new Resume();
        r.init();
        r.fullname = "Кислин Григорий";
        r.address = "Проживание: Россия, г. Санкт-Петербург";
        r.about = "аналитический склад ума, сильная логика, креативность, инициативность.\n" +
                "Пурист кода и архитектуры. ";
        r.phones.add(new Contact( Contact.Type.PHONE, "+7 (921) 855 0482" ));
        r.contacts.add(new Contact( Contact.Type.EMAIL, "gkislin@yandex.ru" ));
        r.contacts.add(new Contact( Contact.Type.SKYPE, "grigory.kislin" ));
        r.links.add(new Contact( Contact.Type.HABARHABR, "https://habrahabr.ru/users/gkislin/" ));
        r.links.add(new Contact( Contact.Type.GITHUB, "https://github.com/gkislin/" ));
        r.links.add(new Contact( Contact.Type.STACK_OVERFLOW, "hhttp://stackoverflow.com/users/548473/gkislin" ));

        println(r.fullname);

        println(r.address);
        for(Contact p : r.phones) {
            print(p.type + ": " + p.source);
        }
        for(Contact c : r.contacts) {
            print(c.type + ": " + c.source);
        }
        for(Contact l : r.links) {
            print(l.type + ": " + l.source);
        }


        println("Личные качества: " + r.about);
        println("");

        for(Section s : r.sections) {
            println(s.name);
        }

    }

    public static  void print(Object s) {
        System.out.println(s);
    }

    public static  void println(Object s) {
        System.out.println(s);
    }
}
