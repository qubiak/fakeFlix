package pl.qubiak.netflix.Dao.Film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.netflix.Model.Film.FilmModel;
import pl.qubiak.netflix.RowMapper.Film.FilmRowMapper;

import java.util.Date;
import java.util.List;

@Repository
public class FilmDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FilmDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFilm (String title, String category, Date releaseDate) {
        String sql = "INSERT INTO film (title, category, releaseDate) VALUE (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{title, category, releaseDate});
    }

    public void delateFilmById (int id) {
        String sql = "DELATE FROM film WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    public void editFilm (String title, String category, Date releaseDate) {
        String sql = "UPDATE film (title, category, releaseDate) VALUE (?, ?, ?) WHERE id = ?";
        jdbcTemplate.update(sql, title, category, releaseDate);
    }

    public List<FilmModel> showEveryFilms() {
        String sql ="SHOW * FROM film";
        List<FilmModel> films = jdbcTemplate.query(sql, new FilmRowMapper());
        return films;
    }

    public List<FilmModel> filmsBeforePremiere() {
        String sql ="SELECT * FROM film WHERE releaseDate < CURRENT_DATE";
        List<FilmModel> films = jdbcTemplate.query(sql, new FilmRowMapper());
        return films;
    }

    public List<FilmModel> filmsAfterPremiere() {
        String sql = "SELECT * FROM film WHERE releaseDate > CURRENT_DATE";
        List<FilmModel> films = jdbcTemplate.query(sql, new FilmRowMapper());
        return films;
    }


}
