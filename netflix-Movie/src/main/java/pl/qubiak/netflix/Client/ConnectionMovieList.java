package pl.qubiak.netflix.Client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.qubiak.netflix.Model.FilmModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ConnectionMovieList {

    public static List<FilmModel> connectionToMovie(String urlEnds) {

        try {

            URL url = new URL("http://localhost:8081/" + urlEnds);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP ERROR code : " + connection.getResponseCode());
            }

            InputStream responseStream = connection.getInputStream();

            ObjectMapper mapper = new ObjectMapper();

            List<FilmModel> movies = mapper.readValue(responseStream, new TypeReference<List<FilmModel>>() {
            });

            connection.disconnect();

            return movies;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList();
    }
}
