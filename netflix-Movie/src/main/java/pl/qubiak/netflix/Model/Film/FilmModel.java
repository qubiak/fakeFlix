package pl.qubiak.netflix.Model.Film;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class FilmModel {

    @ApiModelProperty(notes = "AUTO_INCREMENT")
    @Id
    private int id;
    private String title;
    private String category;
    private Date releaseDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
