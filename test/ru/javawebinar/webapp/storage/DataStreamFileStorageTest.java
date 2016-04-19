package ru.javawebinar.webapp.storage;

/**
 * GKislin
 * 09.10.2015.
 */
public class DataStreamFileStorageTest extends AbstractStorageTest {
    private static final String STORAGE = ".\\storage";

    public DataStreamFileStorageTest() {
        super(new DataStreamFileStorage(STORAGE));
    }
}
