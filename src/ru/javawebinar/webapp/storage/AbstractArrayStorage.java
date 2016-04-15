package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * GKislin
 * 08.04.2016
 */
abstract public class AbstractArrayStorage extends AbstractStorage {
    protected static final int ARRAY_LIMIT = 50000;

    protected Resume[] array = new Resume[ARRAY_LIMIT];
    protected int size = 0;

    protected abstract void shiftDeleted(int idx);

    protected abstract void insert(Resume r, int idx);

    @Override
    protected boolean exist(Object idx) {
        return (int) idx >= 0;
    }

    @Override
    public void doClear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    protected void doSave(Resume r, Object idx) {
        if (size == ARRAY_LIMIT) {
            throw new ResumeStorageException(r.getUuid(), "Array size limit(" + ARRAY_LIMIT + ") exceeded");
        }
        insert(r, (int) idx);
        size++;
    }

    @Override
    protected void doUpdate(Resume r, Object idx) {
        array[(int) idx] = r;
    }

    @Override
    protected Resume doGet(Object idx) {
        return array[(int) idx];
    }

    @Override
    public void doDelete(Object idx) {
        shiftDeleted((int) idx);
        array[size--] = null;
    }

    @Override
    public List<Resume> getAll() {
        Resume[] copy = Arrays.copyOf(array, size);
        return Arrays.asList(copy);
    }

    @Override
    public int getSize() {
        return size;
    }
}
