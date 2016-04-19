package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.Resume;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * GKislin
 * 23.10.2015.
 */
public class DataStreamFileStorage extends AbstractFileStorage {

    protected final File directory;

    public DataStreamFileStorage(String path) {
        directory = new File(path);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(path + " is not directory");
        }
    }

    @Override
    protected File getContext(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean exist(File file) {
        return file.isFile();
    }

    @Override
    protected void doClear() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                doDelete(file);
            }
        }
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            if (!file.createNewFile()) {
                throw new ResumeStorageException(r.getUuid(), "Couldn't create file " + file.getAbsolutePath());
            }
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
                dos.writeUTF(r.getFullName());
                dos.writeUTF(r.getAbout());

                dos.writeInt(r.getContacts().size());
                for (Map.Entry<ContactType, String> entry : r.getContacts().entrySet()) {
                    dos.writeUTF(entry.getKey().name());
                    dos.writeUTF(entry.getValue());
                }
            }
            //TODO implements section
        } catch (IOException e) {
            throw new ResumeStorageException(r.getUuid(), "File write error", e);
        }
    }

    @Override
    protected void doUpdate(Resume r, File file) {

    }

    @Override
    protected Resume doGet(File file) {
        String uuid = file.getName();
        try {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
                String fullName = dis.readUTF();
                String about = dis.readUTF();
                Resume r = new Resume(file.getName(), fullName, about);

                int contactSize = dis.readInt();
                for (int i = 0; i < contactSize; i++) {
                    r.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
                }
                //TODO implements section
                return r;
            }
        } catch (IOException e) {
            throw new ResumeStorageException(uuid, "File read error", e);
        }
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new ResumeStorageException("File delete error", file.getName());
        }
    }

    @Override
    protected List<Resume> getAll() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
