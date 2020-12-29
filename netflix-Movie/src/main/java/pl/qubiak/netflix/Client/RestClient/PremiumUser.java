package pl.qubiak.netflix.Client.RestClient;

import com.google.gson.Gson;
import pl.qubiak.netflix.Client.Model.Movie;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class PremiumUser {

    URL filmsForPremiumUser;

    {
        try {
            filmsForPremiumUser = new URL("http://localhost:8081/Film/showEveryFilms");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    InputStreamReader readerFilmsForPremiumUser;

    {
        try {
            readerFilmsForPremiumUser = new InputStreamReader(filmsForPremiumUser.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Movie premiumMovie = new Gson().fromJson(readerFilmsForPremiumUser, Movie.class);
}
