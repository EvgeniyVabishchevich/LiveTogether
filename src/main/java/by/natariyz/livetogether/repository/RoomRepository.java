package by.natariyz.livetogether.repository;

import by.natariyz.livetogether.entity.Room;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends ListCrudRepository<Room, String> {
    Room findByUrl(String url);
}
