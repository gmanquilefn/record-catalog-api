package cl.gmanquilefn.recordstore.service;

import cl.gmanquilefn.recordstore.entity.ArtistEntity;
import cl.gmanquilefn.recordstore.entity.FormatEntity;
import cl.gmanquilefn.recordstore.entity.RecordEntity;
import cl.gmanquilefn.recordstore.exception.ResourceNotFoundException;
import cl.gmanquilefn.recordstore.model.RecordDTO;
import cl.gmanquilefn.recordstore.model.RecordInfo;
import cl.gmanquilefn.recordstore.model.Response;
import cl.gmanquilefn.recordstore.repository.ArtistRepository;
import cl.gmanquilefn.recordstore.repository.FormatRepository;
import cl.gmanquilefn.recordstore.repository.RecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {

    private static final Logger log = LoggerFactory.getLogger(RecordServiceImpl.class);

    @Autowired
    private ArtistRepository artistRepo;

    @Autowired
    private FormatRepository formatRepo;

    @Autowired
    private RecordRepository recordRepo;

    @Override
    public Response addRecord(RecordDTO request) {

        RecordEntity record = new RecordEntity();

        ArtistEntity artist = artistRepo.findArtistEntityById(request.getArtistId());
        if (artist == null) throw new ResourceNotFoundException("'artistId' does not exists in database");

        FormatEntity format = formatRepo.findFormatEntityById(request.getFormatId());
        if (format == null) throw new ResourceNotFoundException("'formatId' does not exists in database");

        record.setAlbumTitle(request.getAlbumTitle());
        record.setArtistId(artist);
        record.setFormatId(format);
        record.setRecordCode(request.getRecordCode());
        record.setAlbumYear(request.getAlbumYear());
        record.setFabricationYear(request.getFabricationYear());
        record.setFabricationCountry(request.getFabricationCountry());

        recordRepo.save(record);

        return setDataResponseOK();
    }

    @Override
    public List<RecordInfo> getRecords() {
        return recordRepo.findAllBy()
                .stream()
                .map(record -> new RecordInfo(
                        record.getArtistId().getName(),
                        record.getAlbumTitle(),
                        record.getAlbumYear(),
                        record.getFormatId().getDescription(),
                        record.getRecordCode(),
                        record.getFabricationYear(),
                        record.getFabricationCountry()
                ))
                .collect(Collectors.toList());
    }

    private Response setDataResponseOK() {
        return new Response(LocalDateTime.now().toString(),
                HttpStatus.OK.value(),
                "OK");
    }
}
