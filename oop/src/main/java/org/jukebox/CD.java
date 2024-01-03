package org.jukebox;

public class CD implements Listenable {
    @Override
    public void listen() {
        System.out.println("Listening CD");
    }
}
