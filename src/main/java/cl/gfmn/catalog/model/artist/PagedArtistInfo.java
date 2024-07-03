package cl.gfmn.catalog.model.artist;

import java.util.List;

public record PagedArtistInfo(List<ArtistInfo> artists,
                              Boolean first,
                              Boolean last,
                              Integer page_number,
                              Integer page_size,
                              Integer total_pages) {
}
