package cl.gfmn.catalog.service;

import cl.gfmn.catalog.entity.ArtistEntity;
import cl.gfmn.catalog.exception.InvalidRequestDataException;
import cl.gfmn.catalog.exception.ResourceNotFoundException;
import cl.gfmn.catalog.model.Artist;
import cl.gfmn.catalog.model.ArtistInfo;
import cl.gfmn.catalog.model.PagedArtistInfo;
import cl.gfmn.catalog.model.Response;
import cl.gfmn.catalog.repository.ArtistRepository;
import cl.gfmn.catalog.util.Utils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private static final Logger logger = LoggerFactory.getLogger(ArtistService.class);

    private final ArtistRepository artistRepo;

    /**
     * Method that creates an artist in database
     * @param request Artist request
     * @return Response generic POJO
     */
    public Response createArtist(Artist request) {

        if(!artistRepo.findByAliasContains(request.getAlias()).isEmpty())
            throw new InvalidRequestDataException("Artist already exists");

        ArtistEntity artist = new ArtistEntity();

        artist.setAlias(request.getAlias());
        artist.setCode(Utils.generateInterspersedCode(8));
        artist.setCountry(request.getCountry() == null ? "" : request.getCountry());
        artist.setDescription(request.getDescription() == null ? "" : request.getDescription());

        artistRepo.save(artist);

        return new Response("Artist created");
    }

    /**
     * Method that gets all artists from database, paged
     * @param pageRequest PageRequest Object implementation of Pageable
     * @return PageArtistInfo response POJO
     */
    public PagedArtistInfo getAllArtists(PageRequest pageRequest) {

        Page<ArtistEntity> artists = artistRepo.findAll(pageRequest);

        if(!artists.hasContent())
            throw new ResourceNotFoundException("Artists not found");

        return new PagedArtistInfo(artists.getContent()
                .stream()
                .map(artist -> new ArtistInfo(artist.getCode(), artist.getAlias(), artist.getCountry(), artist.getDescription()))
                .collect(Collectors.toList()),
                artists.isFirst(),
                artists.isLast(),
                artists.getNumber() + 1,
                artists.getNumberOfElements(),
                artists.getTotalPages());
    }

    /**
     * Method that updates an artist in database
     * @param request Artist request
     * @param code string of the artist
     * @return Response generic POJO
     */
    public Response updateArtist(Artist request, String code) {

        ArtistEntity artist = artistRepo.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Artist not found"));

        if(!artist.getAlias().equals(request.getAlias()))
            artist.setAlias(request.getAlias());

        if(!artist.getCountry().equals(request.getCountry()))
            artist.setCountry(request.getCountry());

        if(!artist.getDescription().equals(request.getDescription()))
            artist.setDescription(request.getDescription());

        artistRepo.save(artist);

        return new Response("Artist updated");
    }
}
