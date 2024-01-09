package org.filesystem;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class File implements FileSystemItem {

    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        return o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return String.format("file-%d", this.name.hashCode()).hashCode();
    }
}
