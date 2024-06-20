package cl.gfmn.catalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(name = "label")
@Entity
@Data
public class LabelEntity {

    @Id
    @Column(name = "label_id")
    private Integer id;

    @Column(name = "label")
    private String label;

    @Column(name = "description")
    private String description;

    @Column(name = "image_base64")
    private String imageBase64;

    @OneToMany(mappedBy = "label")
    private Set<AlbumReleaseEntity> albumReleases;
}
