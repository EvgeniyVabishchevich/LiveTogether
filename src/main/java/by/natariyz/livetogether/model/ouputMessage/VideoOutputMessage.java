package by.natariyz.livetogether.model.ouputMessage;

import by.natariyz.livetogether.model.PlayerAction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class VideoOutputMessage extends OutputMessage {
    private PlayerAction playerAction;
    private double currentTime;
}
