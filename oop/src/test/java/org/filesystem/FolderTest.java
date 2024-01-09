package org.filesystem;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FolderTest {

    @Test
    public void shouldHoldFiles() {
        var folder = new Folder("folder-0");
        var file = new File("file-0");

        folder.addItem(file);

        assertThat(folder.contains(file)).isTrue();
    }

    @Test
    public void shouldRemoveAFile() {
        var folder = new Folder("folder-0");
        var file = new File("file-0");

        folder.addItem(file);
        folder.removeItem(file);

        assertThat(folder.contains(file)).isFalse();
    }

    @Test
    public void shouldAddAFolder() {
        var folder = new Folder("folder-0");
        var folder1 = new Folder("folder-1");

        folder.addItem(folder1);

        assertThat(folder.contains(folder1)).isTrue();
    }

    @Test
    public void shouldRemoveAFolder() {
        var folder = new Folder("folder-0");
        var folder1 = new Folder("folder-1");

        folder.addItem(folder1);
        folder.removeItem(folder1);

        assertThat(folder.contains(folder1)).isFalse();
    }
}
