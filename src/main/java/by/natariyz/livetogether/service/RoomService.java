package by.natariyz.livetogether.service;

import by.natariyz.livetogether.dto.RoomDto;

public interface RoomService {
    RoomDto findByUrl(String url);

    void save(RoomDto room);

    RoomDto createRoom();
}
