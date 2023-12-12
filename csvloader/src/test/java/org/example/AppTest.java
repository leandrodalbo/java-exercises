package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    public void shouldLoadCSVData() throws FileNotFoundException {
        assertThat(App.loadData()).isNotEmpty();
    }
}
