package cl.gfmn.catalog.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Album requests")
@RestController
@RequestMapping("/api/v1/album")
@RequiredArgsConstructor
public class AlbumController {
}
