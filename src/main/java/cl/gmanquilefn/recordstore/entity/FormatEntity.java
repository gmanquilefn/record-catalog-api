package cl.gmanquilefn.recordstore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Cacheable
@Table(name = "Format")
@Data
public class FormatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "format_id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "formatId")
     private Set<RecordEntity> records;

}
