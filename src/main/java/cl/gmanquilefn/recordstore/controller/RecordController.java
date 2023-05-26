package cl.gmanquilefn.recordstore.controller;

import cl.gmanquilefn.recordstore.model.RecordDTO;
import cl.gmanquilefn.recordstore.model.RecordInfoDTO;
import cl.gmanquilefn.recordstore.model.Response;
import cl.gmanquilefn.recordstore.service.RecordService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@OpenAPIDefinition(
        info = @Info(
                title = "Record Store Simple API",
                description = "a simple API for testing purposes",
                version = "0.0.1"
        )
)

@Tag(name = "Record Requests")
@RestController
@RequestMapping("/v1/api/record")
public class RecordController {

    private static final Logger log = LoggerFactory.getLogger(RecordController.class);

    @Autowired
    private RecordService recordService;

    @Operation(summary = "Allows you to create a record registry in database")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addRecord(@Valid @RequestBody RecordDTO recordDTO) {

        log.info("Begin endpoint consumption POST Record, Request: {}", recordDTO);

        Response response = recordService.addRecord(recordDTO);

        log.info("End endpoint consumption POST Record, Response: {}", response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Allows yo to get information of all records in database")
    public ResponseEntity<RecordInfoDTO> getRecords() {

        log.info("Begin endpoint consumption GET Records");

        RecordInfoDTO recordInfoDTO = new RecordInfoDTO(recordService.getRecords());

        log.info("Begin endpoint consumption GET Records, Response: {}", recordInfoDTO);

        return new ResponseEntity<>(recordInfoDTO, HttpStatus.OK);
    }
}
