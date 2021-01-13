package pl.qubiak.netflix.Client.RestClient;

import pl.qubiak.netflix.Client.ConnectionMovieList;

import java.util.ArrayList;
import java.util.List;

public class FutureFilms {

    public List showFutureFilms() {

        String urlEnds = "Film/filmsBeforePremiere";
        ConnectionMovieList.connectionToMovie(urlEnds);

        return new ArrayList(ConnectionMovieList.connectionToMovie(urlEnds));
    }
}