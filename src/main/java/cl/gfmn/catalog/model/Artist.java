package cl.gfmn.catalog.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Artist {

    @NotBlank(message = "alias must not be blank")
    @NotEmpty(message = "alias must not be empty")
    @NotNull(message = "alias must not be null")
    private String alias;

    private String country;

    private String description;
}
