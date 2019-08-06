import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {

    public static void main(String[] args) {
        Album album1 = new Album("Maroon5");
        Album album2 = new Album("Linkin Park");
        Album album3 = new Album("Sytem");


        album1.addSongToAlbum("Girls Like You", 3);
        album1.addSongToAlbum("Animals", 4);
        album1.addSongToAlbum("Sugar", 3);
        album1.addSongToAlbum("Payphone", 2);

        album2.addSongToAlbum("Numb", 5);
        album2.addSongToAlbum("In The End", 4);
        album2.addSongToAlbum("Somewhere", 3);
        album2.addSongToAlbum("I belong", 3);

        album3.addSongToAlbum("Killing Me", 2);
        album3.addSongToAlbum("Skull Break", 5);



        LinkedList<String> playlist = new LinkedList<String>();
        playlist.add("Girls Like You");
        playlist.add("Numb");
        playlist.add("Sugar");
        playlist.add("Skull Break");
        playlist.add("Somewhere");

        printPlayList(playlist);

        ListIterator<String> playListIterstor = playlist.listIterator();
        if(playListIterstor.hasNext()){
            System.out.println("Now playing -> " + playListIterstor.next());
        }
        Scanner scanner = new Scanner(System.in);
        printMenu();
        boolean loop = false;
        boolean goingFoward = true;
        int count;

        while(!loop){
            System.out.println("Enter your choice");
            count = scanner.nextInt();
            scanner.nextLine();

            switch(count){
                case 0:
                    loop = true;
                    break;
                case 1:
                    if(!goingFoward) {
                        if(playListIterstor.hasNext()){
                            playListIterstor.next();
                        }
                        goingFoward = true;
                    }
                    if(playListIterstor.hasNext()){
                        System.out.println("Song name: " +  playListIterstor.next());
                    }
                    else{
                        System.out.println("End of the list");
                    }
                    break;
                case 2:
                    if(goingFoward){
                        if(playListIterstor.hasPrevious()){
                            playListIterstor.previous();
                        }
                        goingFoward = false;
                    }
                    if (playListIterstor.hasPrevious()){
                        System.out.println("Song name: " + playListIterstor.previous());
                    }
                    else{
                        System.out.println("Start of the list");
                    }
                    break;
                case 3:
                    if(goingFoward) {
                        System.out.println("Song name: " + playListIterstor.previous());
                        goingFoward = false;
                    }
                    else{
                        System.out.println("Song name: " + playListIterstor.next());
                        goingFoward = true;
                    }

                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("1. Skip Forward to the next Song\n" +
                "2. Skip backwards to the previous song\n" +
                "3. replay the song\n" +
                "0. Quit");
    }

    private static boolean printPlayList(LinkedList<String> playlist){
        ListIterator<String> playListIterstor = playlist.listIterator();

        while(playListIterstor.hasNext()){
            System.out.println("Song name: " + playListIterstor.next());

        }


        return true;


    }
}
