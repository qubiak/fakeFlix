package pl.qubiak.netflix.RowMapper;


import org.springframework.jdbc.core.RowMapper;
import pl.qubiak.netflix.Model.FilmModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmRowMapper implements RowMapper<FilmModel> {


    @Override
    public FilmModel mapRow(ResultSet resultSet, int i) throws SQLException {

        FilmModel film = new FilmModel();
        film.setId(resultSet.getInt("id"));
        film.setTitle(resultSet.getString("title"));
        film.setCategory(resultSet.getString("category"));
        film.setReleaseDate(resultSet.getDate("releaseDate"));
        film.setPermium(resultSet.getBoolean("premium"));

        return film;
    }
}
