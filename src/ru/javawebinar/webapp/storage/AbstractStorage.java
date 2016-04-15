package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;

/**
 * GKislin
 * 08.04.2016
 */
abstract public class AbstractStorage implements Storage {
    //    private final static Logger LOG = Logger.getLogger(AbstractStorage.class.getName());
    protected final Logger log = Logger.getLogger(getClass().getName());

    protected abstract Object getContext(String uuid);

    protected abstract boolean exist(Object ctx);

    @Override
    public void clear() {
        log.info("clear");
        doClear();
    }

    protected abstract void doClear();

    private Object getContext(Resume r) {
        return getContext(r.getUuid());
    }

    @Override
    public void save(Resume r) {
        log.info("Save " + r);
        requireNonNull(r, "Resume must not be null");
        Object ctx = getContext(r);
        mustNotExist(r.getUuid(), ctx);
        doSave(r, ctx);
    }

    protected abstract void doSave(Resume r, Object ctx);

    @Override
    public void update(Resume r) {
        log.info("Update " + r);
        requireNonNull(r, "Resume must not be null");
        Object ctx = getContext(r);
        mustExist(r.getUuid(), ctx);
        doUpdate(r, ctx);
    }

    protected abstract void doUpdate(Resume r, Object ctx);

    @Override
    public Resume get(String uuid) {
        log.info("Get " + uuid);
        requireNonNull(uuid, "UUID must not be null");
        Object ctx = getContext(uuid);
        mustExist(uuid, ctx);
        return doGet(ctx);
    }

    protected abstract Resume doGet(Object ctx);

    @Override
    public void delete(String uuid) {
        log.info("Delete " + uuid);
        requireNonNull(uuid, "UUID must not be null");
        Object ctx = getContext(uuid);
        mustExist(uuid, ctx);
        doDelete(ctx);
    }

    protected abstract void doDelete(Object ctx);

    @Override
    public List<Resume> getAllSorted() {
        log.info("getAllSorted");
        List<Resume> list = getAll();
        Collections.sort(list);
        return list;
    }

    protected abstract List<Resume> getAll();

    private void mustNotExist(String uuid, Object ctx) {
        if (exist(ctx)) {
            throw new ResumeStorageException("Resume is already exist in storage", uuid);
        }
    }

    private void mustExist(String uuid, Object ctx) {
        if (!exist(ctx)) {
            throw new ResumeStorageException("Resume not found in storage", uuid);
        }
    }

    @Override
    public int size() {
        int size = getSize();
        log.info("Size: " + size);
        return size;
    }

    protected abstract int getSize();
}
