package pl.qubiak.netflix.Controller.FIlm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.netflix.Dao.Film.FilmDao;
import pl.qubiak.netflix.Model.Film.FilmModel;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Film")
public class filmController {

    @Autowired
    public FilmDao filmDao;

    @RequestMapping("/saveFilm")
    @ResponseBody
    public void saveFilm(
            @RequestParam("title") String title,
            @RequestParam("category") String category,
            @RequestParam("releaseDate")Date releaseDate) {
        filmDao.saveFilm(title, category, releaseDate);
    }

    @RequestMapping("/delateFilmById")
    @ResponseBody
    public void delateFilmById(
            @RequestParam("id") int id) {
        filmDao.delateFilmById(id);
    }

    @RequestMapping("/editFilm")
    @ResponseBody
    public void editFilm(
            @RequestParam("title") String title,
            @RequestParam("category") String category,
            @RequestParam("releaseDate")Date releaseDate) {
        filmDao.editFilm(title, category, releaseDate);
    }

    @RequestMapping("/showEveryFilms")
    @ResponseBody
    public List<FilmModel> showEveryFilms() {
        return filmDao.showEveryFilms();
    }

    @RequestMapping("/filmsBeforePremiere")
    @ResponseBody
    public List<FilmModel> filmsBeforePremiere() {
        return filmDao.filmsBeforePremiere();
    }

    @RequestMapping("/filmsAfterPremiere")
    @ResponseBody
    public List<FilmModel> filmsAfterPremiere() {
        return filmDao.filmsAfterPremiere();
    }
}
