package pl.qubiak.netflixuser.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.netflixuser.Client.Model.Movie;
import pl.qubiak.netflixuser.Dao.User.UserDao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController<movie> {

    final LocalDate today = LocalDate.now();
    final LocalDate plus30Days = today.plusDays(30);
    String plus30DaysDate = plus30Days.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));

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
            @RequestParam("id") int id) {
        userDao.addSubscrypcion(plus30DaysDate, id);
    }

}
