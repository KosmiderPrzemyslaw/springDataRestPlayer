package pl.kosmider.springdatarestplayer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlayerRestExceptionHandler {

    //add exception handling code

    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> handleException(PlayerNotFoundException exception){
        PlayerErrorResponse playerErrorResponse = new PlayerErrorResponse();

        playerErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        playerErrorResponse.setMessage(exception.getMessage());
        playerErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<> (playerErrorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> handleException(Exception exception){

        PlayerErrorResponse playerErrorResponse = new PlayerErrorResponse();

        playerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        playerErrorResponse.setMessage(exception.getMessage());
        playerErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<> (playerErrorResponse, HttpStatus.BAD_REQUEST);


    }

}
