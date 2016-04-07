package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Comparator;
import java.util.List;

/**
 * GKislin
 * 05.04.2016
 */
// TODO implement
public class ArrayStorageImpl implements Storage {
    private static final int ARRAY_LIMIT = 1000;

    private Resume[] array = new Resume[ARRAY_LIMIT];

    private int size = 0;

    @Override
    public void clear() {
        for(int i = 0; i < size; i ++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public void save(Resume r) throws Exception {
        if(size  == ARRAY_LIMIT) {
            throw new Exception("Достигнут предел размера массива!");
        }
        array[size] = r;
        size ++;
    }

    @Override
    public void update(Resume r) throws Exception {
        int inx = getIndexByUuid(r.getUuid());
        if(inx == -1) {
            save(r);
        }
        array[inx] = r;
    }

    @Override
    public Resume get(String uuid) {
        int inx = getIndexByUuid(uuid);
        return inx != -1 ? array[inx] : null;
    }

    @Override
    public void delete(String uuid) throws Exception {
        int inx = getIndexByUuid(uuid);
        if(inx == -1) {
            throw new Exception("Элемент не найден!");
        }
        array[inx] = null;
        for(int i = inx + 1; i < size; i ++) {
            Resume r = array[i];
            array[i - 1] = r;
            array[i] = null;
        }
        size --;
    }

    @Override
    public Collection<Resume> getAllSorted() {
        List<Resume> list = Arrays.asList(array);
        Collections.sort(list, new Comparator<Resume>() {
            public int compare(Resume r1, Resume r2) {
                return r1.getUuid().compareTo(r2.getUuid()) > 0 ? -1 : 1;
            }
        });
        return list;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByUuid(String uuid) {
        for(int i = 0; i < size; i ++) {
            Resume r = array[i];
            if(r != null && uuid.equals(r.getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
