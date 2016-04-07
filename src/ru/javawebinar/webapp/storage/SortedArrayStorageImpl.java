package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;

/**
 * GKislin
 * 05.04.2016
 */

// TODO implements Optional
public class SortedArrayStorageImpl implements Storage{

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
        int inx = size;
        for(int i = 0; i < size; i ++) {
            Resume r1 = array[i];
            int diff = r.getUuid().compareTo(r1.getUuid());
            if(diff > 0) {
                inx = i;
                break;
            }
        }
        for(int i = size - 1; i >= inx; i --) {
            Resume r1 = array[i];
            array[i + 1] = r1;
        }
        array[inx] = r;
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
        return Arrays.asList(array);
    }

    @Override
    public int size() {
        return size;
    }

    public int getIndexByUuid(String uuid) {
        int p = -1;
        int low = 0, high = size, mid;
        while (low < high) {
            mid = (low + high) >>> 1;
            Resume r = this.array[mid];
            int diff = uuid.compareTo(r.getUuid());
            if (diff == 0) {
                p = mid;
                break;
            } else {
                if (diff > 0) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return p;
    }

}
