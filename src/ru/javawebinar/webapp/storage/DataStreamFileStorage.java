package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.Resume;
import ru.javawebinar.webapp.model.SectionType;
import ru.javawebinar.webapp.model.Section;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * GKislin
 * 23.10.2015.
 */
public class DataStreamFileStorage extends AbstractFileStorage {


    public DataStreamFileStorage(String path) {
        super(path);
    }

    @Override
    protected DataInput getReader(File file) throws FileNotFoundException {
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        return dis;
    }

    @Override
    protected DataOutput getWriter(File file) throws FileNotFoundException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        return dos;
    }
}
