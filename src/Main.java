import sun.awt.image.ImageWatched;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by hrith on 12/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        Album album = new Album("Mixtape", "DJ Khaled");
        album.addSong("Mi Gente", 03.19);
        album.addSong("Despacito", 03.20);
        album.addSong("Shakira", 20.00);

        LinkedList<Song> playlist = new LinkedList<Song>();
        album.playAlbum(1, playlist);
        album.playAlbum(2, playlist);
        album.playAlbum(3, playlist);

        musicPlayer(playlist);
    }

    public static void musicPlayer(LinkedList playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if(playlist.isEmpty()){
            System.out.println("No songs to play");
        }else{
            System.out.println("Now playing " + listIterator.next().getTitle());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("Playlist is over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){// needed in order to play the next song only and to stop loops when song is removed
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing: "+ listIterator.next().getTitle());
                    }else{
                        System.out.println("Reached the end of the playlist");
                    }
                    break;
                case 2:
                    if(goingForward){// needed in order to play the previous song only and to stop loops when song is removed
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing: " + listIterator.previous().getTitle());
                    }else{
                        System.out.println("Reached the start of the playlist");
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }


        }

    }
    public static void printMenu(){
        System.out.println("Available actions:\npress ");
        System.out.println("0 - quit\n" +
                "1 - go to next song\n" +
                "2 - go to previous song\n" +
                "3 - print menu options");
    }

}








