package cl.gfmn.catalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "album")
@Data
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistEntity artist;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "album_year")
    private Integer albumYear;

    @Column(name = "genre")
    private String genre;

    @Column(name = "style")
    private String style;

    @Column(name = "track_list")
    private String trackList;

    @OneToMany(mappedBy = "album")
    private Set<AlbumReleaseEntity> albumReleases;
}
