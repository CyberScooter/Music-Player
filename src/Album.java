import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by hrith on 12/07/2017.
 */
public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> album;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.album = new ArrayList<>();
    }//adding name and artist to identify album

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            return album.add(new Song(title, duration));
        }
        return false;
    }

    public Song findSong(String title){
        for(Song checkedSongs : this.album){
            if(checkedSongs.getTitle().equals(title)){
                return checkedSongs;
            }
        }
        return null;
    }

    public boolean playAlbum(int trackNumber, LinkedList<Song> list){
        int index = trackNumber -1;
        if(index >= 0 && index <= this.album.size()){
            list.add(this.album.get(index));
            return true;
        }
        return false;
    }
    public boolean playAlbum(String title, LinkedList<Song> List){
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            List.add(checkedSong);
            return true;
        }
        return false;

    }



}
