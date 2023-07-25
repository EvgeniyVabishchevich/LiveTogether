package by.natariyz.livetogether.repository;

import by.natariyz.livetogether.entity.Film;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends ListCrudRepository<Film, Long> {
    List<Film> findAll();
}
