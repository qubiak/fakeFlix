package pl.qubiak.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.qubiak.netflix.Client.RestClient.MovieClient;

@SpringBootApplication
public class NetflixFilmApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixFilmApplication.class, args);
	}

}
