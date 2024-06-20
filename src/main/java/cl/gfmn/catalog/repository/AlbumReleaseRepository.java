package cl.gfmn.catalog.repository;

import cl.gfmn.catalog.entity.AlbumReleaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumReleaseRepository extends JpaRepository<AlbumReleaseEntity, Integer> {
}
