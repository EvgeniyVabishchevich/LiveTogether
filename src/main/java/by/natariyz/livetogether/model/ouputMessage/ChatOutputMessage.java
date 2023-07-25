package by.natariyz.livetogether.model.ouputMessage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ChatOutputMessage extends OutputMessage {
    private String text;
}
