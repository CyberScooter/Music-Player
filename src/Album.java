import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by hrith on 12/07/2017.
 */
public class Album {
    private String name;
    private String artist;
    private songList song;
    private LinkedList<Song> playlist;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.song = new songList();
        this.playlist = new LinkedList<>();
    }

    public boolean addSong(String title, double duration){
        return this.song.addSong(new Song(title, duration));
    }

    public boolean playSong(int trackNumber, LinkedList<Song> list) {
        int index = trackNumber - 1;
        if (index >= 0 && index <= this.song.getSongStorage().size()) {
            list.add(this.song.getSongStorage().get(index));
            return true;
        }
        return false;
    }

    public void printList(LinkedList playlist){
        if(this.playlist.size() > 0){
            System.out.println("=================================================");
            for(int x = 0; x < playlist.size(); x++){
                System.out.println("Song: " + this.playlist.get(x).getTitle() + "   Duration: " + this.playlist.get(x).getDuration());
            }
            System.out.println("=================================================");
        }
    }

    public boolean playSong(String title, LinkedList<Song> List) {
        Song checkedSong = song.findSong(title);
        if (checkedSong != null) {
            List.add(checkedSong);
            return true;
        }
        return false;

    }

    private class songList {
        ArrayList<Song> songStorage;

        public songList() {
            this.songStorage = new ArrayList<>();
        }

        public boolean addSong(Song song) {
            if (this.songStorage.contains(song)){
                return false;
            }
            songStorage.add(song);
            return true;
        }

        public Song findSong(String title) {
            for (Song checkedSongs : this.songStorage) {
                if (checkedSongs.getTitle().equals(title)) {
                    return checkedSongs;
                }
            }
            return null;


        }

        public void setSongStorage(ArrayList<Song> songStorage) {
            this.songStorage = songStorage;
        }

        public ArrayList<Song> getSongStorage() {
            return songStorage;
        }
    }
}
