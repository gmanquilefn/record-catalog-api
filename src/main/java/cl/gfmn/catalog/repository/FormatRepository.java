package cl.gfmn.catalog.repository;

import cl.gfmn.catalog.entity.FormatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormatRepository extends JpaRepository<FormatEntity, Integer> {
    Optional<FormatEntity> findFormatEntityById(Integer id);
}
