package ru.javawebinar.webapp.storage;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.webapp.model.Resume;

/**
 * Created by vench on 12.04.16.
 */
public class SortedArrayStorageImplTest {

    Storage storege;


    public static Resume newResume(String prefix) {
        return new Resume(prefix + ": My Full name", prefix +": About me");
    }

    @Before
    public void up() {
        storege = new SortedArrayStorageImpl();
    }

    @Test
    public void save() throws Exception {
        for(int i = 0; i < 1000; i ++) {
            storege.save(newResume("N" + i));
            Assert.assertEquals(storege.size(), i + 1);
        }

        storege.clear();
        Assert.assertEquals(storege.size(), 0);
    }

    @Test
    public void update() throws Exception {
        Resume r1 = newResume("1");
        storege.save(r1);
        Assert.assertEquals(storege.get(r1.getUuid()), r1);
        Assert.assertEquals(storege.get(r1.getUuid()).getFullName(), r1.getFullName());

        //Клонируем, что бы не было передачи по ссылке
        Resume r2 = r1.clone();
        r2.setFullName("xxxx");
        Assert.assertNotEquals(storege.get(r1.getUuid()), r2);
        Assert.assertNotEquals(storege.get(r1.getUuid()).getFullName(), r2.getFullName());
    }

    @Test
    public void get() throws Exception {
        for(int i = 0; i < 20; i ++) {
            storege.save(newResume("Before" + i));
        }
        Resume r1 = newResume("1");
        storege.save(r1);
        for(int i = 0; i < 20; i ++) {
            storege.save(newResume("After" + i));
        }
        Assert.assertEquals(storege.get(r1.getUuid()), r1);
    }

    @Test
    public void delete() throws Exception {
        for(int i = 0; i < 20; i ++) {
            storege.save(newResume("Before" + i));
        }
        Resume r1 = newResume("1");
        storege.save(r1);
        for(int i = 0; i < 20; i ++) {
            storege.save(newResume("After" + i));
        }
        Assert.assertEquals(storege.get(r1.getUuid()), r1);

        storege.delete(r1.getUuid());
        try {
            storege.get(r1.getUuid());
            Assert.fail("Элемента не должно быть");
        } catch (Exception e) {}

    }
}
