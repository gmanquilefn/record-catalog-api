package cl.gfmn.catalog.controller;

import cl.gfmn.catalog.model.Artist;
import cl.gfmn.catalog.model.PagedArtistInfo;
import cl.gfmn.catalog.model.Response;
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

@Tag(name = "Artist Requests")
@RestController
@RequestMapping("/api/v1/artist")
@RequiredArgsConstructor
public class ArtistController {

    private static final Logger logger = LoggerFactory.getLogger(ArtistController.class);

    private final ArtistService artistService;

    @Operation(summary = "Creates a new artist")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createArtist(@Valid @RequestBody Artist artist) {
        logger.info("Create artist endpoint consumption");
        return ResponseEntity.ok(artistService.createArtist(artist));
    }

    @Operation(summary = "Gets all artists, paged response")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedArtistInfo> getArtists(@RequestParam(required = true) Integer page_number,
                                                       @RequestParam(required = true) Integer page_size,
                                                       @RequestParam(required = false, defaultValue = "alias") String sort_by) {

        logger.info("Get all artists endpoint consumption");
        return ResponseEntity.ok(artistService.getAllArtists(PageRequest.of(page_number - 1, page_size, Sort.by(Sort.Direction.DESC, sort_by))));
    }

    @Operation(summary = "Updates an artist")
    @PutMapping(path = "/{code}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateArtist(@Valid @RequestBody Artist request, @PathVariable(value = "code", required = true) String code) {
        logger.info("Update artist endpoint consumption");
        return ResponseEntity.ok(artistService.updateArtist(request, code));
    }
}
