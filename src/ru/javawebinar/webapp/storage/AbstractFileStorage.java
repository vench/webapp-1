package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GKislin
 * 23.10.2015.
 */
//TODO implement. Handle all IOException here
public abstract class AbstractFileStorage extends AbstractStorage<File> {

    protected final File directory;


    public AbstractFileStorage(String path) {
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
    protected void doSave(Resume r, File file) {
        try {
            if (!file.createNewFile()) {
                throw new ResumeStorageException(r.getUuid(), "Couldn't create file " + file.getAbsolutePath());
            }

            serialize(r, getWriter(file));

        } catch (IOException e) {
            throw new ResumeStorageException(r.getUuid(), "File write error", e);
        }
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
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new ResumeStorageException("File delete error", file.getName());
        }
    }

    protected Resume unserialize(DataInput in) throws IOException {
        int size = in.readInt();
        byte[] bytes = new byte[size];
        in.readFully(bytes);
        Resume r = null;
        try {
            r = (Resume) convertFromBytes(bytes);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return r;
    }

    protected void serialize(Resume r, DataOutput out) throws IOException {
        byte[] bytes = convertToBytes(r);
        out.writeInt(bytes.length);
        out.write(bytes);
    }

    protected byte[] convertToBytes(Object object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            return bos.toByteArray();
        }
    }

    protected Object convertFromBytes(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        }
    }

    abstract protected DataInput getReader(File file) throws FileNotFoundException;

    abstract protected DataOutput getWriter(File file) throws FileNotFoundException;


    @Override
    protected Resume doGet(File file) {
        String uuid = file.getName();
        try {
            Resume r = unserialize(getReader(file));
            return r;
        } catch (IOException e) {
            throw new ResumeStorageException(uuid, "File read error", e);
        }
    }


    @Override
    protected void doUpdate(Resume r, File file) {
        try {
            if (!file.exists()) {
                throw new ResumeStorageException(r.getUuid(), "Couldn't create file " + file.getAbsolutePath());
            }
            serialize(r, getWriter(file));

        } catch (IOException e) {
            throw new ResumeStorageException(r.getUuid(), "File write error", e);
        }
    }



    @Override
    protected List<Resume> getAll() {
        List<Resume> list = new ArrayList<>();
        for(File file : directory.listFiles()) {
            list.add(  doGet(file) );
        }
        return list.size() > 0 ? list : null;
    }

    @Override
    public int getSize() {
        return  directory.listFiles().length;
    }
}