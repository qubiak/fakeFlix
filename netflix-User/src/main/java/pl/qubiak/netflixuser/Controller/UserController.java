package pl.qubiak.netflixuser.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.netflixuser.Dao.UserDao;
import pl.qubiak.netflixuser.Model.UserModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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
        List<UserModel> date = userDao.readSubscrypcionDate(id);


        //       if (data.after(new Date())) {
        //           return "do końca subsktypcji pozostało" + (data - new Date()) + "dni";
        //       }
        //       else
        //           return "okres subskrypcji zakończył się z dniem: " + data;
        //   }

        return "test" + date;

        //powiedz mi jeszcze czemu tu dostaję pustą date. Wynik tego returna to "test[]"

//
//    public List<pl.qubiak.netflix.Model.FilmModel> premiumMovieList(
//            @RequestParam("id") int id) {
//
//    }

    }
}
