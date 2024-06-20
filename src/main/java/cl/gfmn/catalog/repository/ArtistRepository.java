package cl.gfmn.catalog.repository;

import cl.gfmn.catalog.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {
    List<ArtistEntity> findByAliasContains(String alias);
    List<ArtistEntity> findAllBy(Pageable pageable);
}
