package cl.gfmn.catalog.service;

import cl.gfmn.catalog.entity.ArtistEntity;
import cl.gfmn.catalog.exception.InvalidRequestDataException;
import cl.gfmn.catalog.exception.ResourceNotFoundException;
import cl.gfmn.catalog.model.*;
import cl.gfmn.catalog.model.artist.*;
import cl.gfmn.catalog.repository.ArtistRepository;
import cl.gfmn.catalog.util.Utils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private static final Logger logger = LoggerFactory.getLogger(ArtistService.class);

    private final ArtistRepository artistRepo;

    private final int ARTIST_CODE_LENGTH = 8;

    /**
     * Method that creates an artist
     * @param request Artist request
     * @return ArtistResponse with the created artist
     */
    public ArtistResponse createArtist(Artist request) {

        if(!artistRepo.findByAliasContains(request.getAlias()).isEmpty())
            throw new InvalidRequestDataException("Artist already exists");

        String code = Utils.generateInterspersedCode(ARTIST_CODE_LENGTH);

        artistRepo.save(new ArtistEntity(code,
                request.getAlias(),
                request.getCountry() == null ? "" : request.getCountry(),
                request.getDescription() == null ? "" : request.getDescription()));

        return new ArtistResponse("Artist created",
                new ArtistInfo(code, request.getAlias(), request.getCountry(), request.getDescription()));
    }

    /**
     * Method that creates artists in bulk
     * @param request list of artist
     * @return ArtistsResponse with the processed and not processed artists
     */
    public ArtistsResponse createArtists(List<Artist> request) {

        List<ArtistInfo> processedArtists = new ArrayList<>();
        List<String> notProcessedArtists = new ArrayList<>();

        request.forEach(artist -> {
            if(artistRepo.findByAliasContains(artist.getAlias()).isEmpty()) {
                String code = Utils.generateInterspersedCode(ARTIST_CODE_LENGTH);
                artistRepo.save(new ArtistEntity(code,
                        artist.getAlias(),
                        artist.getCountry() == null ? "" : artist.getCountry(),
                        artist.getDescription() == null ? "" : artist.getDescription()));
                processedArtists.add(new ArtistInfo(code, artist.getAlias(), artist.getCountry(), artist.getDescription()));
            } else {
                notProcessedArtists.add(artist.getAlias());
            }
        });
        return new ArtistsResponse("Artists processed", processedArtists, notProcessedArtists);
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

        ArtistEntity artist = artistRepo.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found"));

        if(!artist.getAlias().equals(request.getAlias()))
            artist.setAlias(request.getAlias());

        if(!artist.getCountry().equals(request.getCountry()))
            artist.setCountry(request.getCountry());

        if(!artist.getDescription().equals(request.getDescription()))
            artist.setDescription(request.getDescription());

        artistRepo.save(artist);

        return new Response("Artist updated");
    }

    /**
     * Method that deletes an artist by code
     * @param code string of the artist
     * @return generic response
     */
    public Response deleteArtist(String code) {

        ArtistEntity artist = artistRepo.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found"));

        artistRepo.delete(artist);

        return new Response("Artist deleted");
    }

    /**
     * Method that deletes artists in bulk by code
     * @param codes string list of the artists
     * @return DeleteArtistsResponse with the deleted codes and the not found codes
     */
    public DeleteArtistsResponse deleteArtists(List<String> codes) {

        List<String> deletedCodes = new ArrayList<>();
        List<String> notFoundCodes = new ArrayList<>();

        codes.forEach(code -> {
            Optional<ArtistEntity> artist = artistRepo.findByCode(code);
            if(artist.isPresent()) {
                deletedCodes.add(artist.get().getCode());
                artistRepo.delete(artist.get());
            } else {
                notFoundCodes.add(code);
            }
        });

        return new DeleteArtistsResponse("Artists deleted", deletedCodes, notFoundCodes);
    }
}
