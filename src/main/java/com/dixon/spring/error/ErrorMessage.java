package com.dixon.spring.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author dixon
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private HttpStatus status;
    private String message;

}
