package ru.javawebinar.webapp.storage;

import org.junit.Before;

/**
 * Created by vench on 12.04.16.
 */
public class ArrayStorageImplTest extends  SortedArrayStorageImplTest {
    @Before
    public void up() {
        storege = new ArrayStorageImpl();
    }
}
