package cl.gfmn.catalog.model.album;

import java.util.List;

public record DeleteAlbumsResponse(String message, List<String> deleted_albums, List<String> not_found_albums) {
}
