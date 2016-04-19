package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.Resume;

import java.io.*;
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
    protected void write(Resume r, OutputStream os) throws IOException {
        try (final DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());
            dos.writeUTF(r.getAbout());

            dos.writeInt(r.getContacts().size());
            for (Map.Entry<ContactType, String> entry : r.getContacts().entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
        }
    }

    @Override
    protected Resume read(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            Resume r = new Resume(dis.readUTF(), dis.readUTF(), dis.readUTF());

            int contactSize = dis.readInt();
            for (int i = 0; i < contactSize; i++) {
                r.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }
            return r;
        }
    }
}
