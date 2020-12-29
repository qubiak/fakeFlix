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
        userModel.getUserName(resultSet.getString("userName"));
        userModel.getEndOfSubscripcionDate(resultSet.getDate("endOfSubscripcionDate"));

        return userModel;
    }
}
