package encapsulation.assigment_problems;

import java.util.Arrays;

// Key idea: never hand out the private array itself. getSongs() returns a copy,
// so callers can modify what they receive without touching the playlist.
class Playlist {
    private final String[] songs;
    private int count = 0;

    Playlist(int maxSize) {
        songs = new String[maxSize];
    }

    void addSong(String title) {
        if (count == songs.length) {
            System.out.println("Playlist full, cannot add: " + title);
            return;
        }
        songs[count++] = title;
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, count); // only the songs added so far, as a new array
    }

    int getSongCount() {
        return count;
    }
}

public class PlaylistManager {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("Copy after tampering: " + Arrays.toString(copy));
        System.out.println("Real playlist:        " + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}
