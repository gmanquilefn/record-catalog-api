package cl.gmanquilefn.recordstore.service;

import cl.gmanquilefn.recordstore.model.RecordDTO;
import cl.gmanquilefn.recordstore.model.RecordInfo;
import cl.gmanquilefn.recordstore.model.Response;

import java.util.List;

public interface RecordService {

    Response addRecord(RecordDTO recordDTO);
    List<RecordInfo> getRecords();
}
