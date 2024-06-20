package cl.gfmn.catalog.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "album_release")
@Entity
@Data
public class AlbumReleaseEntity {

    @Id
    @Column(name = "release_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "format_id")
    private FormatEntity format;

    @ManyToOne
    @JoinColumn(name = "label_id")
    private LabelEntity label;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private AlbumEntity album;

    @Column(name = "code")
    private String code;

    @Column(name = "catalog_number")
    private String catalogNumber;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "country")
    private String country;
}
