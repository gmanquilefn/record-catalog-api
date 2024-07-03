package cl.gfmn.catalog.model.album;

import java.util.List;

public record AlbumInfo(String code,
                        String artist,
                        String title,
                        Integer year,
                        String genre,
                        String style,
                        String description,
                        List<Track> tracklist) {
}
