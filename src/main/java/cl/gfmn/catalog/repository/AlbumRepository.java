package cl.gfmn.catalog.repository;

import cl.gfmn.catalog.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer> {
}
