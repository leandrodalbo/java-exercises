package org.jukebox;

import java.util.List;


public class Jukebox<T extends Listenable> {
    private static final int NOT_LISTENING = -1;
    private final List<T> listenables;
    private int listening;

    public Jukebox(List<T> listenables) {
        this.listenables = listenables;
        this.listening = NOT_LISTENING;
    }

    public void shuffle() {
        for (int i = 0; i < listenables.size(); i++) {
            for (int j = listenables.size() - 1; j > 0; j--) {

                T aux = listenables.get(i);
                listenables.set(i, listenables.get(j));
                listenables.set(j, aux);

            }
        }
    }

    public void start() {
        this.listening = 0;
    }

    public void stop() {
        this.listening = NOT_LISTENING;
    }

    public void next() {

        if (this.listening == (this.listenables.size() - 1)) {
            this.listening = 0;
        } else {
            this.listening++;
        }
    }

    public void previous() {
        if (this.listening == 0) {
            this.listening = this.listenables.size() - 1;
        } else {
            this.listening--;
        }

    }

    public int getListening() {
        return listening;
    }
}
