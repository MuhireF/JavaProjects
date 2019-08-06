import java.util.ArrayList;

public class Album {

    private String name;
    private ArrayList<Song> albumList;

    public Album(String name) {
        this.name = name;
        this.albumList = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getAlbumList() {
        return albumList;
    }

    public void addSongToAlbum(String name, int duration){
        Song song = storeSong(name, duration);
        albumList.add(song);
        System.out.println("Song " + song.getTitle() + " successfully added!");
    }

    private Song storeSong(String name, int duration){
        return new Song(name, duration);
    }
}
