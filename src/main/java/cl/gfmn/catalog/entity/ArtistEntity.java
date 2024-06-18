package cl.gfmn.catalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Cacheable
@Table(name = "Artist")
@Data
public class ArtistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "artistId")
    private Set<RecordEntity> records;
}
