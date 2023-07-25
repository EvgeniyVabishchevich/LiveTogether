package by.natariyz.livetogether.service;

import by.natariyz.livetogether.dto.UserDto;

public interface UserService {
    void save(UserDto userDto, String password);
}
