package cl.gfmn.catalog.model.artist;

import java.util.List;

public record DeleteArtistRequest(List<String> artist_codes) {
}
