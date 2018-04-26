package me.soulyana.imdb.Controllers;

import me.soulyana.imdb.Models.Artiste;
import me.soulyana.imdb.Models.Song;
import me.soulyana.imdb.Repositories.ArtisteRepository;
import me.soulyana.imdb.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    ArtisteRepository artisteRepository;

    @Autowired
    SongRepository songRepository;

    //full page background
    @RequestMapping("/")
    public String showHomepage(Model model) {
        model.addAttribute("menuoption", "homepage");
        return "homepage";
    }

    //add an artiste
    @RequestMapping("/addartiste")
    public String artisteForm(Model model) {
        model.addAttribute("menuoption", "addartiste");
        model.addAttribute("anArtiste", new Artiste());
        return "artisteform";
    }

    //update an artiste
    @RequestMapping("/updateartiste")
    public String editArtiste(HttpServletRequest request, Model model) {
        long artisteID = new Long(request.getParameter("id"));
        model.addAttribute("anArtiste", artisteRepository.findById(artisteID).get());
        return "artisteform";
    }

    @PostMapping("/addartiste")
    public String processArtisteForm(@Valid @ModelAttribute("anArtiste") Artiste artiste, BindingResult result) {
        if (result.hasErrors()) {
            return "artisteform";
        }
        artisteRepository.save(artiste);
        return "redirect:/listartistes";
    }

    //list all Artistes
    @RequestMapping("/listartistes")
    public String showListArtistes(Model model) {
        model.addAttribute("menuoption", "listartistes");
        model.addAttribute("artistes", artisteRepository.findAll());
        return "listartistes";
    }

    //add a song
    @RequestMapping("/addsong")
    public String songForm(Model model, HttpServletRequest request) {
        //navbar
        model.addAttribute("menuoption", "addsong");

        //Get an artiste id (if there is one)
        String artisteID = request.getParameter("artisteid");

        Song theSong = new Song();

        //Associate a song with an artiste if the artiste's ID is passed as a parameter
        /*if(artisteID == null) {
            theSong.setLeadArtiste(artisteRepository.findById(new Long(artisteID)).get());
        }*/

        model.addAttribute("aSong", theSong);
        model.addAttribute("artistes", artisteRepository.findAll());
        return "songform";
    }

    //update a song
    @RequestMapping("/updatesong")
    public String editSong(HttpServletRequest request, Model model) {
        long songID = new Long(request.getParameter("id"));
        model.addAttribute("aSong", songRepository.findById(songID).get());
        return "songform";
    }

    @RequestMapping("/savesong")
    public String processSongForm(@Valid @ModelAttribute("aSong") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "songform";
        }
        songRepository.save(song);
        return "redirect:/";
    }

    //list all songs
    @RequestMapping("/listsongs")
    public String showListSongs(Model model) {
        model.addAttribute("menuoption", "listsongs");
        model.addAttribute("artistes", artisteRepository.findAll());
        return "listsongs";
    }

}
