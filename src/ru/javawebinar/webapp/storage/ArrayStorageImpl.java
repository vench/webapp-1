package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Objects.requireNonNull;

/**
 * GKislin
 * 05.04.2016
 */
public class ArrayStorageImpl extends AbstractArrayStorageImpl {

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (array[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void putToArray(Resume r, int idx) {
        array[size++] = r;
    }

    protected void cutToArray(int idx) {
        array[idx] = array[--size];
        array[size] = null;
    }
}
