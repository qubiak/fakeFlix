package pl.qubiak.netflix.Controller.FIlm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.netflix.Dao.Film.FilmDao;
import pl.qubiak.netflix.Model.Film.FilmModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
            @RequestParam("date")String date,
            @RequestParam("premium")boolean premium) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC+1"));
        Date releaseDate = formatter.parse(date);

        filmDao.saveFilm(title, category, releaseDate, premium);
    }

    @RequestMapping("/deleteFilmById")
    @ResponseBody
    public void deleteFilmById(
            @RequestParam("id") int id) {
        filmDao.deleteFilmById(id);
    }

    @RequestMapping("/editFilm")
    @ResponseBody
    public void editFilm(
            @RequestParam("title") String title,
            @RequestParam("category") String category,
            @RequestParam("date")String date,
            @RequestParam("premium")boolean premium) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC+1"));
        Date releaseDate = formatter.parse(date);

        filmDao.editFilm(title, category, releaseDate, premium);
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

    @RequestMapping("/filmsForStandardUser")
    @ResponseBody
    public List<FilmModel> filmsForStandardUser() { return filmDao.filmForStandardUser();}
}
