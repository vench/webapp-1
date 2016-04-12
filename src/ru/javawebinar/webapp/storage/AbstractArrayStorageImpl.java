package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeException;
import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Objects.requireNonNull;

/**
 * GKislin
 * 08.04.2016
 */
abstract public class AbstractArrayStorageImpl extends AbstractStorageImpl {
    protected static final int ARRAY_LIMIT = 50000;

    protected Resume[] array = new Resume[ARRAY_LIMIT];
    protected int size = 0;

    protected int getExistedIndex(String uuid) {
        int idx = getIndex(uuid);
        if (idx < 0) {
            throw new ResumeException(uuid, "Resume with " + uuid + "not exist");
        }
        return idx;
    }

    protected abstract int getIndex(String uuid);
    protected abstract void putToArray(Resume r, int idx);
    protected abstract void cutToArray(int idx);

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    final public void save(Resume r) {
        requireNonNull(r, "Resume must not be null");
        int idx = getIndex(r.getUuid());
        if (idx != -1) {
            throw new IllegalArgumentException("Resume " + r.getUuid() + "already exist");
        }
        if (size == ARRAY_LIMIT) {
            throw new IllegalStateException("Max storage volume " + ARRAY_LIMIT + " is exceeded");
        }
        putToArray(r, idx);
    }

    @Override
    final public void delete(String uuid) {
        requireNonNull(uuid);
        cutToArray ( getExistedIndex(uuid) );
    }


    @Override
    public void update(Resume r) {
        requireNonNull(r);
        array[getExistedIndex(r.getUuid())] = r;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public Resume get(String uuid) {
        requireNonNull(uuid);
        return array[getExistedIndex(uuid)];
    }

    @Override
    public Collection<Resume> getAllSorted() {
        Resume[] copy = Arrays.copyOf(array, size);
        Arrays.sort(copy);
        return Arrays.asList(copy);
    }

}
