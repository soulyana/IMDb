package me.soulyana.imdb.Controllers;

import me.soulyana.imdb.Models.Artiste;
import me.soulyana.imdb.Models.Song;
import me.soulyana.imdb.Repositories.ArtisteRepository;
import me.soulyana.imdb.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    ArtisteRepository artisteRepository;

    @Autowired
    SongRepository songRepository;

    //full page background
    @RequestMapping("/")
    public String showHomepage() {
        return "homepage";
    }

    //add an artiste
    @RequestMapping("/addartiste")
    public String artisteForm(Model model) {
        model.addAttribute("artiste", new Artiste());
        return "artisteform";
    }

    @PostMapping("/processartiste")
    public String processArtisteForm(@Valid Artiste artiste, BindingResult result) {
        if (result.hasErrors()) {
            return "artisteform";
        }
        artisteRepository.save(artiste);
        return "redirect:/listartistes";
    }

    //list all Artistes
    @RequestMapping("/listartistes")
    public String showListArtistes(Model model) {
        model.addAttribute("artistes", artisteRepository.findAll());
        return "listartistes";
    }

    //add a song
    @RequestMapping("/addsong")
    public String songForm(Model model) {
        model.addAttribute("song", new Song());
        return "songform";
    }

    @PostMapping("/processsong")
    public String processSongForm(@Valid Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "songform";
        }
        songRepository.save(song);
        return "redirect:/listsongs";
    }

    //list all songs
    @RequestMapping("/listsongs")
    public String showListSongs(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "listsongs";
    }

}
