package cl.gfmn.catalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "format")
@Data
public class FormatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "format_id")
    private Integer id;

    @Column(name = "format")
    private String format;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "format")
     private Set<AlbumReleaseEntity> AlbumReleases;
}
