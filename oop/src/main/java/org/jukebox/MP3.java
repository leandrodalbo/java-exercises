package org.jukebox;

public class MP3 implements Listenable {
    @Override
    public void listen() {
        System.out.println("Listening MP3");
    }
}
