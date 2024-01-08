package org.htable;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomHTableTest {

    @Test
    public void willCreateAHashTableOfSize() {
        assertThat(new CustomHTable<Integer, Integer>(3).getSize()).isEqualTo(3);
    }

    @Test
    public void willPutAndGet() {
        var table = new CustomHTable<Integer, Integer>(3);

        table.put(1, 1);

        assertThat(table.get(1)).isEqualTo(1);

    }
}
