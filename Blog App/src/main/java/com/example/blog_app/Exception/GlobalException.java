package com.example.blog_app.Exception;

import com.example.blog_app.Payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
    {
        String message  = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> response=new HashMap<>();
        /* get all error and fetch the error according */
        ex.getBindingResult().getAllErrors().forEach((error)->{
            //type cast to field error
            String fieldName=((FieldError)error).getField();
            String message = error.getDefaultMessage();
            response.put(fieldName,message);
        });
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
     }

}
