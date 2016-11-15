package org.ncedu.entity;

import javax.persistence.*;

/**
 * Created by nick on 14.11.16.
 */
@Entity
@Table (name = "User_Playlist")
public class UserPlaylist {
    @ManyToOne (fetch = FetchType.LAZY)
    @Column (name = "user_id")
    private long user_id;

    @ManyToOne (fetch = FetchType.LAZY)
    @Column (name = "playlist_id")
    private long playlist_id;

    @Column (name = "isCreatorRoom")
    private Boolean isCreatorRoom;

    public UserPlaylist(long user_id, long playlist_id, Boolean isCreatorRoom) {
        this.user_id = user_id;
        this.playlist_id = playlist_id;
        this.isCreatorRoom = isCreatorRoom;
    }

    public UserPlaylist() {
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(long playlist_id) {
        this.playlist_id = playlist_id;
    }

    public Boolean getCreatorRoom() {
        return isCreatorRoom;
    }

    public void setCreatorRoom(Boolean creatorRoom) {
        isCreatorRoom = creatorRoom;
    }


    @Override
    public String toString() {
        return "UserPlaylist{" +
                "user_id=" + user_id +
                ", playlist_id=" + playlist_id +
                ", isCreatorRoom=" + isCreatorRoom +
                '}';
    }
}
