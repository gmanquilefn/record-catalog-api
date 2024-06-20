package cl.gfmn.catalog.controller;

import cl.gfmn.catalog.model.Artist;
import cl.gfmn.catalog.model.ArtistInfo;
import cl.gfmn.catalog.model.Response;
import cl.gfmn.catalog.service.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@Tag(name = "Artist Requests")
@RestController
@RequestMapping("/api/v1/artist")
@RequiredArgsConstructor
public class ArtistController {

    private static final Logger logger = LoggerFactory.getLogger(ArtistController.class);

    private final ArtistService artistService;

    @Operation(summary = "Creates a new artist in database")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createArtist(@Valid @RequestBody Artist artist) {
        logger.info("Create artist endpoint consumption");
        return ResponseEntity.ok(artistService.createArtist(artist));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistInfo>> getArtists(Pageable pageable) {
        return ResponseEntity.ok(artistService.getArtists(pageable));
    }

}
