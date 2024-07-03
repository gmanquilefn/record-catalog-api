package cl.gfmn.catalog.model.artist;

import java.util.List;

public record DeleteArtistsRequest(List<String> artist_codes) {
}
