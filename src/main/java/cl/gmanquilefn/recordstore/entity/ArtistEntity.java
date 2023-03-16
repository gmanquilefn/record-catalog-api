package cl.gmanquilefn.recordstore.entity;

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
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "artist_code")
    private String artistCode;

    @OneToMany(mappedBy = "artistId")
    private Set<RecordEntity> records;
}
