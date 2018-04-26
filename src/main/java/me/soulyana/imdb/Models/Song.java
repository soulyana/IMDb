package me.soulyana.imdb.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private int yearReleased;

    //There are many songs, but each of them is led by ONE artiste.
    //The Artiste's ID is represented in the song table as leadArtiste
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leadArtiste")
    private Artiste leadArtiste;

    public Song() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public Artiste getLeadArtiste() {
        return leadArtiste;
    }

    public void setLeadArtiste(Artiste leadArtiste) {
        this.leadArtiste = leadArtiste;
    }
}
