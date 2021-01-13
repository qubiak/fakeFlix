package pl.qubiak.netflix.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.netflix.Model.FilmModel;
import pl.qubiak.netflix.RowMapper.FilmRowMapper;

import java.util.Date;
import java.util.List;

@Repository
public class FilmDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FilmDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFilm (String title, String category, Date releaseDate, boolean premium) {
        String sql = "INSERT INTO film (id, title, category, releaseDate, premium) VALUE (NULL, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{title, category, releaseDate, premium});
    }

    public void deleteFilmById (int id) {
        String sql = "DELETE FROM film WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    public void editFilm (String title, String category, Date releaseDate, boolean premium) {
        String sql = "UPDATE film (title, category, releaseDate, premium) VALUE (?, ?, ?, ?) WHERE id = ?";
        jdbcTemplate.update(sql, title, category, releaseDate, premium);
    }

    public List<FilmModel> showEveryFilms() {
        String sql ="SELECT * FROM film";
        List<FilmModel> films = jdbcTemplate.query(sql, new FilmRowMapper());
        return films;
    }

    public List<FilmModel> filmsBeforePremiere() {
        String sql ="SELECT * FROM film WHERE releaseDate > CURRENT_DATE";
        List<FilmModel> films = jdbcTemplate.query(sql, new FilmRowMapper());
        return films;
    }

    public List<FilmModel> filmsAfterPremiere() {
        String sql = "SELECT * FROM film WHERE releaseDate < CURRENT_DATE";
        List<FilmModel> films = jdbcTemplate.query(sql, new FilmRowMapper());
        return films;
    }

    public List<FilmModel> filmForStandardUser() {
        String sql = "SELECT * FROM film WHERE premium = false";
        List<FilmModel> filmsStandard = jdbcTemplate.query(sql, new FilmRowMapper());
        return filmsStandard;
    }
}
