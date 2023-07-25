package by.natariyz.livetogether.controller.webSocket;

import by.natariyz.livetogether.model.inputMessage.InputMessage;
import by.natariyz.livetogether.model.ouputMessage.OutputMessage;
import by.natariyz.livetogether.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageHandlingController {
    private final MessageService messageService;

    @MessageMapping("/communication/{roomUrl}")
    @SendTo("/topic/{roomUrl}")
    public OutputMessage send(@DestinationVariable String roomUrl, @Payload InputMessage inputMessage) {
        return messageService.getOutputMessageFromInputMessage(inputMessage);
    }
}
