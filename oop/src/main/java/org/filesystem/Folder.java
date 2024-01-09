package org.filesystem;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemItem {

    private final List<FileSystemItem> items = new ArrayList<>();
    private final String name;

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return String.format("folder-%d", name.hashCode()).hashCode();
    }

    public void addItem(FileSystemItem item) {
        this.items.add(item);
    }


    public void removeItem(FileSystemItem item) {
        this.items.remove(item);
    }

    public boolean contains(FileSystemItem item) {
        return this.items.contains(item);
    }
}
