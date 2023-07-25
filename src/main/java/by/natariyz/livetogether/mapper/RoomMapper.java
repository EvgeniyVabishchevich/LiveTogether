package by.natariyz.livetogether.mapper;

import by.natariyz.livetogether.dto.RoomDto;
import by.natariyz.livetogether.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room roomDtoToRoom(RoomDto roomDto);

    RoomDto roomToRoomDto(Room room);
}
