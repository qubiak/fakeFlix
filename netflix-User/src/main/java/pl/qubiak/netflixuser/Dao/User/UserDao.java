package pl.qubiak.netflixuser.Dao.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveUser(String userName){
        String sql ="INSERT INTO user (user_Name, end_Of_Subscripcion_Date) VALUE (?, CURRENT_DATE)";
        jdbcTemplate.update(sql, new Object[]{userName});
    }

    public void deletaUserById(int id){
        String sql = "DELETE FROM user WHERE id =?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    public void addSubscrypcion(String plus30DaysDate, int id){

        String sql ="UPDATE user SET end_Of_Subscripcion_Date = ? where ID = ?";
        jdbcTemplate.update(sql, plus30DaysDate, id);
    }


}
