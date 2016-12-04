package blankthings.strack.Sections.Playlist;

/**
 * Created by iosifvilcea on 5/17/16.
 */
public class Song {

    private String title;
    private String artist;
    private String url;

    public Song(final String title, final String artist, final String url) {
        this.title = title;
        this.artist = artist;
        this.url = url;
    }

    public Song(final Song song) {
        title = song.getTitle();
        artist = song.getArtist();
        url = song.getUrl();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
