package cl.gfmn.catalog.model.album;

import jakarta.validation.constraints.*;

import java.util.List;

public class Album {

    @NotBlank(message = "artist_code must not be blank")
    @NotEmpty(message = "artist_code must not be empty")
    @NotNull(message = "artist_code must not be null")
    private String artist_code;

    @NotBlank(message = "title must not be blank")
    @NotEmpty(message = "title must not be empty")
    @NotNull(message = "title must not be null")
    private String title;

    @Min(value = 1900, message = "year must be from 1900 onwards")
    @Digits(integer = 4, fraction = 0, message = "year must be in format 'yyyy'")
    private Integer year;

    private String genre;

    private String style;

    private String description;

    @NotEmpty(message = "tracklist must not be empty")
    private List<Track> tracklist;
}
