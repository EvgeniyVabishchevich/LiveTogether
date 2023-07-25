package by.natariyz.livetogether.model.inputMessage;

import by.natariyz.livetogether.model.MessageType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "messageType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ChatInputMessage.class, name = "CHAT"),
        @JsonSubTypes.Type(value = VideoInputMessage.class, name = "PLAYER")
})
public class InputMessage {
    private MessageType messageType;
    private String sender;
}
