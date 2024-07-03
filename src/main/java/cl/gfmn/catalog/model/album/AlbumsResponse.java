package cl.gfmn.catalog.model.album;

import java.util.List;

public record AlbumsResponse(String message, List<AlbumInfo> processed_albums, List<String> not_processed_albums) {
}
