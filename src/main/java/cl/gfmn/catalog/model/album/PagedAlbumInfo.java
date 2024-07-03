package cl.gfmn.catalog.model.album;

import java.util.List;

public record PagedAlbumInfo(List<AlbumInfo> albums,
                             Boolean first,
                             Boolean last,
                             Integer page_number,
                             Integer page_size,
                             Integer total_pages) {
}
