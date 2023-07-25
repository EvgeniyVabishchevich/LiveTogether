package by.natariyz.livetogether.service.impl;

import by.natariyz.livetogether.dto.FilmDto;
import by.natariyz.livetogether.mapper.FilmMapper;
import by.natariyz.livetogether.repository.FilmRepository;
import by.natariyz.livetogether.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;

    @Override
    public List<FilmDto> findAll() {
        return filmRepository.findAll().stream()
                .map(filmMapper::filmToFilmDto)
                .toList();
    }
}
