package by.natariyz.livetogether.model.ouputMessage;

import by.natariyz.livetogether.model.MessageType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OutputMessage {
    private MessageType messageType;
    private String sender;
}
