package cl.gmanquilefn.recordstore.repository;

import cl.gmanquilefn.recordstore.entity.FormatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormatRepository extends JpaRepository<FormatEntity, Integer> {
    FormatEntity findFormatEntityById(Integer id);
}
