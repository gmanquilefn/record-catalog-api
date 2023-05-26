package cl.gmanquilefn.recordstore.repository;

import cl.gmanquilefn.recordstore.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {
    ArtistEntity findArtistEntityById(Integer id);
}
