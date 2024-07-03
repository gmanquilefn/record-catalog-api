package cl.gfmn.catalog.controller;

import cl.gfmn.catalog.model.*;
import cl.gfmn.catalog.model.artist.*;
import cl.gfmn.catalog.service.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Artist Requests")
@RestController
@RequestMapping("/api/v1/artist")
@RequiredArgsConstructor
public class ArtistController {

    private static final Logger logger = LoggerFactory.getLogger(ArtistController.class);

    private final ArtistService artistService;

    @Operation(summary = "Create a new artist")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtistResponse> createArtist(@Valid @RequestBody Artist artist) {
        logger.info("Create artist endpoint consumption");
        return ResponseEntity.ok(artistService.createArtist(artist));
    }

    @Operation(summary = "Creates new artists in bulk")
    @PostMapping(path = "/bulk", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtistsResponse> createArtists(@Valid @RequestBody List<Artist> artists) {
        logger.info("Create artists endpoint consumption, list size = {}", artists.size());
        return ResponseEntity.ok(artistService.createArtists(artists));
    }

    @Operation(summary = "Get all artists, paged response")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedArtistInfo> getArtists(@RequestParam(required = true, defaultValue = "1") Integer page_number,
                                                       @RequestParam(required = true, defaultValue = "10") Integer page_size,
                                                       @RequestParam(required = false, defaultValue = "alias") String sort_by) {

        logger.info("Get all artists endpoint consumption");
        return ResponseEntity.ok(artistService.getAllArtists(PageRequest.of(page_number - 1, page_size, Sort.by(Sort.Direction.DESC, sort_by))));
    }

    @Operation(summary = "Update an artist")
    @PutMapping(path = "/{code}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateArtist(@Valid @RequestBody Artist request, @PathVariable(value = "code", required = true) String code) {
        logger.info("Update artist endpoint consumption");
        return ResponseEntity.ok(artistService.updateArtist(request, code));
    }

    @Operation(summary = "Delete an artist")
    @DeleteMapping(path = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteArtist(@PathVariable String code) {
        logger.info("Delete artist endpoint consumption");
        return ResponseEntity.ok(artistService.deleteArtist(code));
    }

    @Operation(summary = "Deletes artists in bulk")
    @DeleteMapping(path = "/bulk", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeleteArtistsResponse> deleteArtists(@RequestBody DeleteArtistsRequest request) {
        logger.info("Delete artists endpoint consumption, list size = {}", request.artist_codes().size());
        return ResponseEntity.ok(artistService.deleteArtists(request.artist_codes()));
    }
}
