package pl.qubiak.netflixuser.Client.RestClient;

import com.google.gson.Gson;
import pl.qubiak.netflixuser.Client.Model.Movie;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class StandardUser {

    URL filmsForStandardUser;

    {
        try {
            filmsForStandardUser = new URL("http://localhost:8081/Film/filmsForStandardUser");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    InputStreamReader readerFilmsForStandardUser;

    {
        try {
            readerFilmsForStandardUser = new InputStreamReader(filmsForStandardUser.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Movie standardMovie = new Gson().fromJson(readerFilmsForStandardUser, Movie.class);

}
