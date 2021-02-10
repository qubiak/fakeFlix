package pl.qubiak.netflix.Client.RestClient;

import pl.qubiak.netflix.Client.ConnectionMovieList;
import pl.qubiak.netflix.Model.FilmModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NetflixMovieClient {

    public List<FilmModel> showEveryFilms() {

        String urlEnds = "Film/showEveryFilms";
        List<FilmModel> con = ConnectionMovieList.connectionToMovie(urlEnds);

        return new ArrayList(Collections.singleton(con));
    }

    public List<FilmModel> showStandardFilms() {

        String urlEnds = "Film/filmsForStandardUser";
        List<FilmModel> con = ConnectionMovieList.connectionToMovie(urlEnds);

        return new ArrayList(Collections.singleton(con));
    }

    public List<FilmModel> showFutureFilms() {

        String urlEnds = "Film/filmsBeforePremiere";
        List<FilmModel> con = ConnectionMovieList.connectionToMovie(urlEnds);

        return new ArrayList(Collections.singleton(con));
    }

}
