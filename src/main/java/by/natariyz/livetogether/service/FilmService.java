package by.natariyz.livetogether.service;

import by.natariyz.livetogether.dto.FilmDto;

import java.util.List;

public interface FilmService {
    List<FilmDto> findAll();
}
