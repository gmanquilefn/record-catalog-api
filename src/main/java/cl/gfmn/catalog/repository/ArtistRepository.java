package cl.gfmn.catalog.repository;

import cl.gfmn.catalog.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {
    List<ArtistEntity> findByAliasContains(String alias);
    Optional<ArtistEntity> findByCode(String code);
}
