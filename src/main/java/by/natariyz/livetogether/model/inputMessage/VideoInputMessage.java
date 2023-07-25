package by.natariyz.livetogether.model.inputMessage;

import by.natariyz.livetogether.model.PlayerAction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VideoInputMessage extends InputMessage {
    private PlayerAction playerAction;
    private double currentTime;
}
