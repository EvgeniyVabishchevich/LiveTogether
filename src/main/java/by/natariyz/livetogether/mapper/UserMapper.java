package by.natariyz.livetogether.mapper;

import by.natariyz.livetogether.dto.UserDto;
import by.natariyz.livetogether.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDtoToUser(UserDto userDTO);

    UserDto userToUserDto(User user);
}
