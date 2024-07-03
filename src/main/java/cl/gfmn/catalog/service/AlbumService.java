package cl.gfmn.catalog.service;

import cl.gfmn.catalog.repository.AlbumRepository;
import cl.gfmn.catalog.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private static final Logger logger = LoggerFactory.getLogger(AlbumService.class);

    private final AlbumRepository albumRepo;
    private final ArtistRepository artistRepo;

    private final int ALBUM_CODE_LENGTH = 10;

}
