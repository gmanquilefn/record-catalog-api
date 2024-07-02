package cl.gfmn.catalog.model.artist;

import java.util.List;

public record ArtistsResponse(String message, List<ArtistInfo> processed_artists, List<String> not_processed_artists) {
}
