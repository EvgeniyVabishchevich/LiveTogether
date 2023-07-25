package by.natariyz.livetogether.service.impl;

import by.natariyz.livetogether.model.inputMessage.ChatInputMessage;
import by.natariyz.livetogether.model.inputMessage.InputMessage;
import by.natariyz.livetogether.model.inputMessage.VideoInputMessage;
import by.natariyz.livetogether.model.ouputMessage.ChatOutputMessage;
import by.natariyz.livetogether.model.ouputMessage.OutputMessage;
import by.natariyz.livetogether.model.ouputMessage.VideoOutputMessage;
import by.natariyz.livetogether.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public OutputMessage getOutputMessageFromInputMessage(InputMessage inputMessage) {
        OutputMessage outputMessage = null;

        switch (inputMessage.getMessageType()) {
            case CHAT -> {
                ChatInputMessage chatInputMessageData = (ChatInputMessage) inputMessage;
                ChatOutputMessage chatOutputMessageData = new ChatOutputMessage();

                chatOutputMessageData.setText(chatInputMessageData.getText());

                outputMessage = chatOutputMessageData;
            }

            case PLAYER ->  {
                VideoInputMessage videoInputMessage = (VideoInputMessage) inputMessage;
                VideoOutputMessage videoOutputMessage = new VideoOutputMessage();

                videoOutputMessage.setPlayerAction(videoInputMessage.getPlayerAction());
                videoOutputMessage.setCurrentTime(videoInputMessage.getCurrentTime());

                outputMessage = videoOutputMessage;
            }
        }

        outputMessage.setSender(inputMessage.getSender());
        outputMessage.setMessageType(inputMessage.getMessageType());

        return outputMessage;
    }
}
