package org.ncedu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by nick on 14.11.16.
 */
@Entity
@Table (name = "Playlist")
public class Playlist {
    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column (name = "playlist_id")
    private long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "room_id", nullable = false)
    @Column (name = "room_id")
    private long room_id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "music_id", nullable = false)
    @Column (name = "music_id")
    private long music_id;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "User_Playlist")
    private Set<UserPlaylist> userPlaylists;

    public Playlist(long id, long room_id, long music_id) {
        this.id = id;
        this.room_id = room_id;
        this.music_id = music_id;
    }

    public Playlist() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(long room_id) {
        this.room_id = room_id;
    }

    public long getMusic_id() {
        return music_id;
    }

    public void setMusic_id(long music_id) {
        this.music_id = music_id;
    }

    public Set<UserPlaylist> getUserPlaylists() {
        return userPlaylists;
    }

    public void setUserPlaylists(Set<UserPlaylist> userPlaylists) {
        this.userPlaylists = userPlaylists;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", room_id=" + room_id +
                ", music_id=" + music_id +
                '}';
    }
}
