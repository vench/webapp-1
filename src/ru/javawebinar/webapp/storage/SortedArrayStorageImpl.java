package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static java.util.Objects.requireNonNull;

/**
 * GKislin
 * 05.04.2016
 */

public class SortedArrayStorageImpl extends AbstractArrayStorageImpl {
    @Override
    protected int getIndex(String uuid) {
        return Arrays.binarySearch(array, 0, size, new Resume(uuid, "", null), new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
                return o1.getUuid().compareTo(o2.getUuid());
            }
        });
    }

    @Override
    protected void putToArray(Resume r, int idx) {
        int insertIdx = -idx - 1;
        System.arraycopy(array, insertIdx, array, insertIdx + 1, size - insertIdx);
        array[idx] = r;
        size++;
    }

    @Override
    protected void cutToArray(int idx) {
        int numMoved = size - idx - 1;
        if (numMoved > 0) {
            System.arraycopy(array, idx + 1, array, idx, numMoved);
        }
        array[--size] = null;
    }
}
