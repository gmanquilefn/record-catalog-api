package cl.gmanquilefn.recordstore.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecordDTO {

    @NotNull(message = "'artistId' must not be null")
    private Integer artistId;

    @NotNull(message = "'formatId' must not be null")
    private Integer formatId;

    @NotBlank(message = "'albumTitle' must not be blank")
    @NotEmpty(message = "'albumTitle' must not be empty")
    @NotNull(message = "'albumTitle' must not be null")
    private String albumTitle;

    @NotNull(message = "'albumYear' must not be null")
    @Min(value = 1900, message = "'albumYear' year must be from 1900 onwards")
    @Digits(integer = 4, fraction = 0, message = "'albumYear' must be in format 'yyyy'")
    private Integer albumYear;

    @NotBlank(message = "'recordCode' must not be blank")
    @NotEmpty(message = "'recordCode' must not be empty")
    @NotNull(message = "'recordCode' must not be null")
    private String recordCode;

    @NotNull(message = "'fabricationYear' must not be null")
    @Min(value = 1900, message = "'fabricationYear' year must be from 1900 onwards")
    @Digits(integer = 4, fraction = 0, message = "'fabricationYear' must be in format 'yyyy'")
    private Integer fabricationYear;

    @NotBlank(message = "'fabricationCountry' must not be blank")
    @NotEmpty(message = "'fabricationCountry' must not be empty")
    @NotNull(message = "'fabricationCountry' must not be null")
    private String fabricationCountry;

}
