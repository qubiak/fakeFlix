package pl.qubiak.netflixuser.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.netflixuser.Model.UserModel;
import pl.qubiak.netflixuser.RowMapper.UserRowMapper;

import java.util.Date;
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

    public void addSubscrypcion(String todayPlusSubscripcionLengthDate, int id){
        String sql ="UPDATE user SET end_Of_Subscripcion_Date = ? where ID = ?";
        jdbcTemplate.update(sql, todayPlusSubscripcionLengthDate, id);
    }

    public List<Map<String, Object>> showUserById(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        List<Map<String, Object>> user = jdbcTemplate.queryForList(sql, new UserRowMapper());
        return user;
    }

    public Date subscriptionStatus(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        UserModel subscriptionStatus = jdbcTemplate.queryForObject(sql ,new Object[]{id}, new UserRowMapper());
        return subscriptionStatus.getEndOfSubscripcionDate();
    }

}
