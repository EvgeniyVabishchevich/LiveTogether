package by.natariyz.livetogether.service.impl;

import by.natariyz.livetogether.dto.RoomDto;
import by.natariyz.livetogether.entity.Room;
import by.natariyz.livetogether.mapper.RoomMapper;
import by.natariyz.livetogether.repository.RoomRepository;
import by.natariyz.livetogether.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public RoomDto findByUrl(String url) {
        Room room = roomRepository.findByUrl(url);

        return roomMapper.roomToRoomDto(room);
    }

    @Override
    public void save(RoomDto roomDto) {
        Room room = roomMapper.roomDtoToRoom(roomDto);

        roomRepository.save(room);
    }

    @Override
    public RoomDto createRoom() {
        String url = UUID.randomUUID().toString();
        RoomDto roomDto = new RoomDto(url);

        save(roomDto);

        return roomDto;
    }
}
