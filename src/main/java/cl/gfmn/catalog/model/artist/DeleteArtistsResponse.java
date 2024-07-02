package cl.gfmn.catalog.model.artist;

import java.util.List;

public record DeleteArtistsResponse(String message, List<String> deleted_artists, List<String> not_found_artists) {
}
