package cl.gfmn.catalog.service;

import cl.gfmn.catalog.repository.FormatRepository;
import cl.gfmn.catalog.model.Record;
import cl.gfmn.catalog.model.Response;
import cl.gfmn.catalog.repository.ArtistRepository;
import cl.gfmn.catalog.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RecordService {

    private static final Logger logger = LoggerFactory.getLogger(RecordService.class);

    private final ArtistRepository artistRepo;
    private final FormatRepository formatRepo;
    private final AlbumRepository recordRepo;

    public Response addRecord(Record request) {

//        AlbumEntity record = new AlbumEntity();
//
//        ArtistEntity artist = artistRepo.findArtistEntityById(request.getArtist_id()).orElseThrow(() -> new ResourceNotFoundException("Artist not found"));
//        FormatEntity format = formatRepo.findFormatEntityById(request.getFormat_id()).orElseThrow(() -> new ResourceNotFoundException("Format not found"));
//
//        record.setAlbumTitle(request.getAlbum_title());
//        record.setArtistId(artist);
//        record.setFormatId(format);
//        record.setRecordCode(request.getRecord_code());
//        record.setAlbumYear(request.getAlbum_year());
//        record.setFabricationYear(request.getFabrication_year());
//        record.setFabricationCountry(request.getFabrication_country());
//
//        recordRepo.save(record);

        return null;
    }

//    public List<RecordInfo> getRecords() {
//        return recordRepo.findAllBy()
//                .stream()
//                .map(record -> new RecordInfo(
//                        record.getArtistId().getName(),
//                        record.getAlbumTitle(),
//                        record.getAlbumYear(),
//                        record.getFormatId().getDescription(),
//                        record.getRecordCode(),
//                        record.getFabricationYear(),
//                        record.getFabricationCountry()
//                ))
//                .collect(Collectors.toList());
//    }

//    private Response setDataResponseOK() {
//        return new Response(LocalDateTime.now().toString(),
//                HttpStatus.OK.value(),
//                "OK");
//    }
}
