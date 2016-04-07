package ru.javawebinar.webapp.storage

import main.MainArrayStorage
import org.junit.Test
import ru.javawebinar.webapp.model.Resume

/**
 * Created by vench on 07.04.16.
 */
class SortedArrayStorageImplTest extends groovy.util.GroovyTestCase {




    @Test
    public void testAdd() {
        int limit = 1000;
        SortedArrayStorageImpl arayStorageImpl = new SortedArrayStorageImpl();
        for(int i = 0; i < limit; i ++) {
            arayStorageImpl.save( MainArrayStorage.newResume("V" + i) );
        }

        assertEquals(arayStorageImpl.size(), limit)
    }

    @Test
    public void testGet() {
        SortedArrayStorageImpl arayStorageImpl = new SortedArrayStorageImpl();

        for(int i = 0; i < 20; i ++) {
            arayStorageImpl.save( MainArrayStorage.newResume("Z" + i) );
        }
        Resume resume = MainArrayStorage.newResume("V1");
        arayStorageImpl.save(resume);
        for(int i = 0; i < 20; i ++) {
            arayStorageImpl.save( MainArrayStorage.newResume("A" + i) );
        }
        Resume resume1 = arayStorageImpl.get( resume.getUuid() );


    }

    @Test
    public void testDelete() {

        Resume resume = MainArrayStorage.newResume("V1");

        SortedArrayStorageImpl arayStorageImpl = new SortedArrayStorageImpl();
        arayStorageImpl.save(resume);
        assertEquals(arayStorageImpl.size(), 1);
        arayStorageImpl.delete(resume.getUuid());
        assertEquals(arayStorageImpl.size(), 0);
    }

    @Test
    public void testUpdate() {
        Resume resume = MainArrayStorage.newResume("U1");

        SortedArrayStorageImpl arayStorageImpl = new SortedArrayStorageImpl();
        arayStorageImpl.save(resume);
        Resume resume1 = arayStorageImpl.get(resume.getUuid());

        assertEquals(resume.getFullName(), resume1.getFullName());
        String newName = "New Name cckdmcks";

        resume1.setFullName(newName);
        arayStorageImpl.update(resume1);

        Resume resume2 = arayStorageImpl.get(resume.getUuid());

        assertEquals(resume2.getFullName(), newName);
        assertEquals(arayStorageImpl.size(), 1);
    }

}
