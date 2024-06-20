package cl.gfmn.catalog.controller;

import cl.gfmn.catalog.model.Record;
import cl.gfmn.catalog.model.RecordInfo;
import cl.gfmn.catalog.model.Response;
import cl.gfmn.catalog.service.RecordService;
import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "Record Catalog API",
                description = "a simple API for testing purposes and full stack integrations",
                version = "0.0.2"
        )
)

@Tag(name = "Record Requests")
@RestController
@RequestMapping("/api/v1/record")
@RequiredArgsConstructor
public class RecordController {

    private static final Logger logger = LoggerFactory.getLogger(RecordController.class);

    private final RecordService recordService;

    private final Gson gson = new Gson();

    @Operation(summary = "Allows you to create a record registry in database")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addRecord(@Valid @RequestBody Record request) {

        logger.info("Begin endpoint consumption POST Record, request = {}", gson.toJson(request));

        Response response = recordService.addRecord(request);

        logger.info("End endpoint consumption POST Record, Response: {}", response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Allows yo to get information of all records in database")
    public ResponseEntity<List<RecordInfo>> getRecords() {

        logger.info("Begin endpoint consumption GET Records");

        //List<RecordInfo> records = recordService.getRecords();
        List<RecordInfo> records = new ArrayList<>();

        logger.info("Begin endpoint consumption GET Records, Response: {}", gson.toJson(records));

        return new ResponseEntity<>(records, HttpStatus.OK);
    }
}
