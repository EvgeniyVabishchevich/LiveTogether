package by.natariyz.livetogether.mapper;

import by.natariyz.livetogether.dto.FilmDto;
import by.natariyz.livetogether.entity.Film;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmMapper {
    Film filmDtoToFilm(FilmDto filmDto);

    FilmDto filmToFilmDto(Film film);
}
