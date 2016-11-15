package org.ncedu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by nick on 14.11.16.
 */
@Entity
@Table (name = "Music")
public class Music {
    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column (name = "music_id")
    private long id;

    @Column (name = "name")
    private String name;

    @Column (name = "track_link")
    private String track_link;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Playlist")
    private Set<Playlist> playlists;

    public Music(long id, String name, String track_link) {
        this.id = id;
        this.name = name;
        this.track_link = track_link;
    }

    public Music() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrack_link() {
        return track_link;
    }

    public void setTrack_link(String track_link) {
        this.track_link = track_link;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }


    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", track_link='" + track_link + '\'' +
                '}';
    }
}
