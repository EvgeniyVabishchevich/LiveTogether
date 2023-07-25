package by.natariyz.livetogether.service.impl;

import by.natariyz.livetogether.dto.UserDto;
import by.natariyz.livetogether.entity.User;
import by.natariyz.livetogether.mapper.UserMapper;
import by.natariyz.livetogether.repository.UserRepository;
import by.natariyz.livetogether.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(UserDto userDto, String password) {
        User user = userMapper.userDtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);
    }
}
