package worship;

import java.util.Date;
import java.util.List;

public class SundaySetlist {

    private Date date;
    private Musician worshipLeader;
    private Musician guitarPlayer;
    private Musician drumsPlayer;
    private Musician bassPlayer;
    private Musician keysPlayer;
    private List<Song> songList;
    //private ___ songOrder;


    public SundaySetlist(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Musician getWorshipLeader() {
        return worshipLeader;
    }

    public void setWorshipLeader(Musician worshipLeader) {
        this.worshipLeader = worshipLeader;
    }

    public Musician getGuitarPlayer() {
        return guitarPlayer;
    }

    public void setGuitarPlayer(Musician guitarPlayer) {
        this.guitarPlayer = guitarPlayer;
    }

    public Musician getDrumsPlayer() {
        return drumsPlayer;
    }

    public void setDrumsPlayer(Musician drumsPlayer) {
        this.drumsPlayer = drumsPlayer;
    }

    public Musician getBassPlayer() {
        return bassPlayer;
    }

    public void setBassPlayer(Musician bassPlayer) {
        this.bassPlayer = bassPlayer;
    }

    public Musician getKeysPlayer() {
        return keysPlayer;
    }

    public void setKeysPlayer(Musician keysPlayer) {
        this.keysPlayer = keysPlayer;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
