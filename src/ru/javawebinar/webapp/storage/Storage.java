package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.Collection;

/**
 * GKislin
 * 29.03.2016
 */
public interface Storage {
    void clear();

    void save(Resume r) throws Exception;

    void update(Resume r) throws Exception;

    Resume get(String uuid);

    void delete(String uuid) throws Exception;

    Collection<Resume> getAllSorted();

    int size();
}
