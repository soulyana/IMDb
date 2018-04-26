package me.soulyana.imdb.Models;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artiste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 2)
    private String fullName;

    @NotNull
    private String stageName;

    @NotNull
    private String image;

    //One artiste HAS many songs. And in each Song, the artiste's ID is represented by 'leadArtiste'.
    //Look at the database after adding a song to understand this relationship.
    @OneToMany(mappedBy = "leadArtiste")
    public Set<Song> songs;

    public Artiste() {
        songs = new HashSet<>();
    }

    public Artiste(String fullName) {
        this.fullName = fullName;
        songs = new HashSet<>();
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStageName() {
        if(stageName==null) {
            return fullName;
        }
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Artiste{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }

}
