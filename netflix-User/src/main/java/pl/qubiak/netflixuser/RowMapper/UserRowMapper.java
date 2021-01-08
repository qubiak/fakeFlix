package pl.qubiak.netflixuser.RowMapper;

import org.springframework.jdbc.core.RowMapper;
import pl.qubiak.netflixuser.Model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserModel> {


    @Override
    public UserModel mapRow(ResultSet resultSet, int i) throws SQLException {
        UserModel userModel = new UserModel();
        userModel.setId(resultSet.getInt("id"));
        userModel.setUserName(resultSet.getString("user_Name"));
        userModel.setEndOfSubscripcionDate(resultSet.getDate("end_Of_Subscripcion_Date"));

        return userModel;
    }
}
