package alexdev.doggyapp;


import alexdev.doggyapp.app.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DoggyExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> handleException(Exception e) {

        if(e instanceof ValidationException v) {
            return ResponseEntity.badRequest().body(MessageResponse.list(v.getErrors()));
        }

        if(e instanceof HttpRequestMethodNotSupportedException) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(MessageResponse.single(e.getMessage()));
        }

        return ResponseEntity.internalServerError().body(MessageResponse.single(e.getMessage()));
    }

}
