package cl.gmanquilefn.recordstore.repository;

import cl.gmanquilefn.recordstore.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<RecordEntity, Integer> {
    List<RecordEntity> findAllBy();
}
