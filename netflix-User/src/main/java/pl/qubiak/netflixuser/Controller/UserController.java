package pl.qubiak.netflixuser.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.qubiak.netflix.Client.RestClient.NetflixMovieClient;
import pl.qubiak.netflix.Model.FilmModel;
import pl.qubiak.netflixuser.Dao.UserDao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/User")
public class UserController {

    NetflixMovieClient client = new NetflixMovieClient();

    @Autowired
    private UserDao userDao;
    private List<FilmModel> MovieClientTest;

    @RequestMapping("/saveUser")
    @ResponseBody
    public void saveUser(
            @RequestParam("userName") String userName) {
        userDao.saveUser(userName);
    }

    @RequestMapping("/delateUserById")
    @ResponseBody
    public void delateUserById(
            @RequestParam("id") int id) {
        userDao.deletaUserById(id);
    }


    @RequestMapping("/addSubscryption")
    @ResponseBody
    public void addSubscryption(
            @RequestParam("id") int id,
            @RequestParam("subscriptionLength") int subscriptionLength) {
        final LocalDate today = LocalDate.now();
        final LocalDate todayPlusSubscripcionLength = today.plusDays(subscriptionLength);
        String todayPlusSubscripcionLengthDate = todayPlusSubscripcionLength.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        userDao.addSubscrypcion(todayPlusSubscripcionLengthDate, id);
    }

    @RequestMapping("/subscriptionStatus")
    @ResponseBody
    public String getSubscriptionStatus(
            @RequestParam("id") int id) {
        try {
            Date date = userDao.subscriptionStatus(id);

            if (date.after(new Date())) {
                return "Your subscription lasts until " + date.toString();
            } else
                return "subscription period ended";
        } catch (EmptyResultDataAccessException e) {
            return "ERROR!! No user with ID: " + id;
        }
    }

    @RequestMapping("/movieList")
    @ResponseBody
    public List<FilmModel> getMovieList(
            @RequestParam("id") int id) {
        try {
            Date date = userDao.subscriptionStatus(id);

            if (date.after(new Date())) {
                return client.showEveryFilms();
            } else {
                return client.showStandardFilms();
            }
        } catch (EmptyResultDataAccessException e) {
            System.out.println("ERROR!! No user with ID: " + id);
            return new ArrayList<>();
        }
    }

    @RequestMapping("/FutureFilms")
    @ResponseBody
    public List<FilmModel> getFutureFilm() {
        return client.showFutureFilms();
    }

}