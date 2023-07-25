package by.natariyz.livetogether.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such room.")
public class RoomNotFoundException extends Exception {
}
