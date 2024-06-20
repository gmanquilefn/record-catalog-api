package cl.gfmn.catalog.repository;

import cl.gfmn.catalog.entity.LabelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<LabelEntity, Integer> {
}
