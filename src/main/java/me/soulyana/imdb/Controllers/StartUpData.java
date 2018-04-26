package me.soulyana.imdb.Controllers;

import me.soulyana.imdb.Models.Artiste;
import me.soulyana.imdb.Repositories.ArtisteRepository;
import me.soulyana.imdb.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StartUpData {

    @Autowired
    ArtisteRepository artisteRepository;

    @Autowired
    SongRepository songRepository;

    @PostConstruct
    public void showListArtistes() {
        Artiste anArtiste = new Artiste();
        anArtiste.setFullName("Robert Rihmeek Williams");
        anArtiste.setStageName("Meek Mill");
        anArtiste.setImage("/images/meekmill.jpg");
        artisteRepository.save(anArtiste);

        anArtiste = new Artiste();
        anArtiste.setFullName("Jason Emmanuel Petty");
        anArtiste.setStageName("Propaganda");
        anArtiste.setImage("/images/propaganda.jpg");
        artisteRepository.save(anArtiste);

        anArtiste = new Artiste();
        anArtiste.setFullName("Jackie Hill-Perry");
        anArtiste.setStageName("Jakcie Hill-Perry");
        anArtiste.setImage("/images/jackie.jpg");
        artisteRepository.save(anArtiste);

    }
}
