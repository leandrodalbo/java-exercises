package org.jukebox;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JukeboxTest {

    @Test
    public void shouldBeAbleToListenCDs() {
        List<CD> cds = List.of(new CD(), new CD());
        Jukebox box = new Jukebox(cds);

        box.start();

        assertThat(box.getListening() == 0).isTrue();

    }

    @Test
    public void shouldBeAbleToListenMP3s() {
        List<MP3> mp3s = List.of(new MP3(), new MP3());
        Jukebox box = new Jukebox(mp3s);

        box.start();

        assertThat(box.getListening() == 0).isTrue();

    }

    @Test
    public void shouldBeAbleToStopIt() {
        List<MP3> mp3s = List.of(new MP3(), new MP3());
        Jukebox box = new Jukebox(mp3s);

        box.start();
        box.stop();

        assertThat(box.getListening() < 0).isTrue();

    }

    @Test
    public void shouldBeAbleToPlayTheFollowingSong() {
        List<MP3> mp3s = List.of(new MP3(), new MP3());
        Jukebox box = new Jukebox(mp3s);

        box.start();
        box.next();

        assertThat(box.getListening() > 0).isTrue();

    }

    @Test
    public void shouldBeAbleToPlayThePreviousSong() {
        List<MP3> mp3s = List.of(new MP3(), new MP3());
        Jukebox box = new Jukebox(mp3s);

        box.start();
        box.next();
        box.previous();

        assertThat(box.getListening() == 0).isTrue();

    }
}
