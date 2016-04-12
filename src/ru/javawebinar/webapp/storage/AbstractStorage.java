package ru.javawebinar.webapp.storage;

import java.util.logging.Logger;

/**
 * GKislin
 * 08.04.2016
 */
abstract public class AbstractStorage implements Storage {
    protected final Logger log = Logger.getLogger(getClass().getName());
}
