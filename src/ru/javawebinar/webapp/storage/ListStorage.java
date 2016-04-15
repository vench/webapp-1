package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> list = new ArrayList<>();

    @Override
    protected boolean exist(Object idx) {
        return (int) idx >= 0;
    }

    @Override
    protected Integer getContext(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doClear() {
        list.clear();
    }

    @Override
    protected void doSave(Resume r, Object idx) {
        list.add(r);
    }

    @Override
    protected void doUpdate(Resume r, Object idx) {
        list.set((int) idx, r);
    }

    @Override
    protected Resume doGet(Object idx) {
        return list.get((int) idx);
    }

    @Override
    protected void doDelete(Object idx) {
        list.remove((int) idx);
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>(list);
    }

    @Override
    public int getSize() {
        return list.size();
    }
}
