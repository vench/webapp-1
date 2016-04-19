package ru.javawebinar.webapp.storage;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileNotFoundException;

import java.nio.file.Path;

/**
 * GKislin
 * 23.10.2015.
 */
// TODO Optional
public class PathStorage extends AbstractFileStorage {


    public PathStorage(String path) {
        super(path);
    }


    @Override
    protected DataInput getReader(File file) throws FileNotFoundException {
         
        return null;
    }

    @Override
    protected DataOutput getWriter(File file) throws FileNotFoundException {
        return null;
    }
}
