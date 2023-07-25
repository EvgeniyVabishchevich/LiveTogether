package by.natariyz.livetogether.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomDto {
    private String url;

    public RoomDto(String url) {
        this.url = url;
    }
}
