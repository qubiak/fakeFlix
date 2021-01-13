package pl.qubiak.netflix.Client.RestClient;

import pl.qubiak.netflix.Client.ConnectionMovieList;

import java.util.ArrayList;
import java.util.List;

public class PremiumMovieClient {

    public List showEveryFilms() {


        String urlEnds = "Film/showEveryFilms";
        ConnectionMovieList.connectionToMovie(urlEnds);

        return new ArrayList(ConnectionMovieList.connectionToMovie(urlEnds));
    }
}