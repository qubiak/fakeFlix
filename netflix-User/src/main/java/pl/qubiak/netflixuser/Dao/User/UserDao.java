package pl.qubiak.netflixuser.Dao.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.netflixuser.Model.User.UserModel;
import pl.qubiak.netflixuser.RowMapper.User.UserRowMapper;

import java.util.List;
import java.util.Map;


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

    public List<Map<String, Object>> showUserById(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        List<Map<String, Object>> user = jdbcTemplate.queryForList(sql, new UserRowMapper());
        return user;

        /*
        Dobra chciałem zrobić cos takiego jak:
        - pobrać Usera
        - sprawdzić end_Of_Subscripcion_Date
        - jeżeli end_Of_Subscripcion_Date > CIRRENT_DATE to:
        - wypisać premiumMovie
        - jeżeli ! (end_Of_Subscripcion_Date > CIRRENT_DATE) to:
        - wypisać standardMovie
         */
    }

}
