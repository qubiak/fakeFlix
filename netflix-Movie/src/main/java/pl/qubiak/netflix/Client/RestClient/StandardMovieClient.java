package pl.qubiak.netflix.Client.RestClient;

import pl.qubiak.netflix.Client.ConnectionMovieList;

import java.util.ArrayList;
import java.util.List;

public class StandardMovieClient {

    public List showStandardFilms() {

        String urlEnds = "Film/filmsForStandardUser";
        ConnectionMovieList.connectionToMovie(urlEnds);

        return new ArrayList(ConnectionMovieList.connectionToMovie(urlEnds));
    }
}