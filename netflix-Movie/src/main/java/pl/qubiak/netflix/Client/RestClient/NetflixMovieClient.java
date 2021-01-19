package pl.qubiak.netflix.Client.RestClient;

import pl.qubiak.netflix.Client.ConnectionMovieList;
import pl.qubiak.netflix.Model.FilmModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NetflixMovieClient {

    public List<FilmModel> showEveryFilms() {

        String urlEnds = "Film/showEveryFilms";
        ConnectionMovieList.connectionToMovie(urlEnds);

        return new ArrayList(Collections.singleton(ConnectionMovieList.connectionToMovie(urlEnds)));
    }

    public List<FilmModel> showStandardFilms() {

        String urlEnds = "Film/filmsForStandardUser";
        ConnectionMovieList.connectionToMovie(urlEnds);

        return new ArrayList(Collections.singleton(ConnectionMovieList.connectionToMovie(urlEnds)));
    }

    public List<FilmModel> showFutureFilms() {

        String urlEnds = "Film/filmsBeforePremiere";
        ConnectionMovieList.connectionToMovie(urlEnds);

        return new ArrayList(Collections.singleton(ConnectionMovieList.connectionToMovie(urlEnds)));
    }

}
