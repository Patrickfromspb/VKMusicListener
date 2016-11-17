package org.ncedu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by nick on 14.11.16.
 */
@Entity
@Table (name = "User")
public class User {
    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column (name = "user_id")
    private long id;

    @Column (name = "name")
    private String name;

    @Column (name = "vk_link")
    private String vk_link;

    @Column (name = "auth_token")
    private String auth_token;

    @Column (name = "registration")
    private Date registration;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "User_Playlist")
    private Set<UserPlaylist> playlists;

    public User(long id, String name, String vk_link, String auth_token, Date registration) {
        this.id = id;
        this.name = name;
        this.vk_link = vk_link;
        this.auth_token = auth_token;
        this.registration = registration;
    }

    public User() {
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

    public String getVk_link() {
        return vk_link;
    }

    public void setVk_link(String vk_link) {
        this.vk_link = vk_link;
    }

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public Set<UserPlaylist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<UserPlaylist> playlists) {
        this.playlists = playlists;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vk_link='" + vk_link + '\'' +
                ", auth_token='" + auth_token + '\'' +
                ", registration=" + registration +
                '}';
    }
}
