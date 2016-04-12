package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * GKislin
 * 05.04.2016
 */

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void insert(Resume r, int idx) {
//      http://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
        int insertIdx = -idx - 1;
        System.arraycopy(array, insertIdx, array, insertIdx + 1, size - insertIdx);
        array[insertIdx] = r;
    }

    @Override
    public void shiftDeleted(String uuid, int idx) {
        int numMoved = size - idx - 1;
        if (numMoved > 0) {
            System.arraycopy(array, idx + 1, array, idx, numMoved);
        }
    }

    protected int getIndex(String uuid) {
        return Arrays.binarySearch(array, 0, size, new Resume(uuid, "", null), new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
                return o1.getUuid().compareTo(o2.getUuid());
            }
        });
    }
}
