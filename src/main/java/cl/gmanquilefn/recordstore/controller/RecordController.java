package cl.gmanquilefn.recordstore.controller;

import cl.gmanquilefn.recordstore.model.Record;
import cl.gmanquilefn.recordstore.model.Response;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/api")
public class RecordController {

    private static final Logger log = LoggerFactory.getLogger(RecordController.class);

    @PostMapping(path = "/record", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addRecord(@Valid @RequestBody Record record) {

        log.info(record.toString());

        return new ResponseEntity<>(new Response(LocalDateTime.now(), HttpStatus.OK.value(), "OK"), HttpStatus.OK );
    }
}
