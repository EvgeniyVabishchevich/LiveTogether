package by.natariyz.livetogether.service;

import by.natariyz.livetogether.model.inputMessage.InputMessage;
import by.natariyz.livetogether.model.ouputMessage.OutputMessage;

public interface MessageService {
    OutputMessage getOutputMessageFromInputMessage(InputMessage inputMessage);
}
