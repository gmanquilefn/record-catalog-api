package cl.gfmn.catalog.service;

import cl.gfmn.catalog.entity.ArtistEntity;
import cl.gfmn.catalog.exception.InvalidRequestDataException;
import cl.gfmn.catalog.model.Artist;
import cl.gfmn.catalog.model.ArtistInfo;
import cl.gfmn.catalog.model.Response;
import cl.gfmn.catalog.repository.ArtistRepository;
import cl.gfmn.catalog.util.Utils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private static final Logger logger = LoggerFactory.getLogger(ArtistService.class);

    private final ArtistRepository artistRepo;

    public Response createArtist(Artist request) {

        if(!artistRepo.findByAliasContains(request.getAlias()).isEmpty())
            throw new InvalidRequestDataException("Artist already exists");

        ArtistEntity artist = new ArtistEntity();

        artist.setAlias(request.getAlias());
        artist.setCode(Utils.generateInterspersedCode(8));
        artist.setCountry(request.getCountry() == null ? "" : request.getCountry());
        artist.setDescription(request.getDescription() == null ? "" : request.getDescription());

        artistRepo.save(artist);

        return new Response(LocalDateTime.now().toString(), HttpStatus.OK.value(), "Artist created");
    }

    public List<ArtistInfo> getArtists(Pageable pageable) {
        return artistRepo.findAllBy(pageable)
                .stream()
                .map(artist -> new ArtistInfo(artist.getCode(), artist.getAlias(), artist.getCountry(), artist.getDescription()))
                .collect(Collectors.toList());
    }
}
