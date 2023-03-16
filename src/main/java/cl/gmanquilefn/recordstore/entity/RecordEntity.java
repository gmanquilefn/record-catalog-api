package cl.gmanquilefn.recordstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Cacheable
@Table(name = "Record")
@Data
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistEntity artistId;

    @ManyToOne
    @JoinColumn(name = "format_id")
    private FormatEntity formatId;

    @Column(name = "album_title")
    private String albumTitle;

    @Column(name = "album_year")
    private Integer albumYear;

    @Column(name = "record_code")
    private String recordCode;

    @Column(name = "fabrication_year")
    private Integer fabricationYear;

    @Column(name = "fabrication_country")
    private String fabricationCountry;
}
