package cl.gfmn.catalog.model.album;

import java.util.List;

public record DeleteAlbumsRequest(List<String> album_codes) {
}
