package cl.gfmn.catalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "artist")
@Data
public class ArtistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "alias")
    private String alias;

    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "artist")
    private Set<AlbumEntity> albums;
}
