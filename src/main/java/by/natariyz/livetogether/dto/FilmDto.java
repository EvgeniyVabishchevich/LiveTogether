package by.natariyz.livetogether.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FilmDto {
    private Long id;

    private String title;

    private String description;

    private String path;
}
