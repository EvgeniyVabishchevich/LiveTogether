package by.natariyz.livetogether.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private long id;
    private String login;
    private String username;

    public UserDto(String login) {
        this.login = login;
        this.username = login;
    }
}
