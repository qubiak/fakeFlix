package pl.qubiak.netflixuser.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.netflixuser.Dao.UserDao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserDao userDao;

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
    public String subscriptionStatus(
            @RequestParam("id") int id) {
        Date date = userDao.subscriptionStatus(id);

        if (date.after(new Date())) {
            return "Your subscription lasts until " + date.toString();
        }
        else
            return "subscription period ended";
    }

//
//    public List<pl.qubiak.netflix.Model.FilmModel> premiumMovieList(
//            @RequestParam("id") int id) {
//

}
