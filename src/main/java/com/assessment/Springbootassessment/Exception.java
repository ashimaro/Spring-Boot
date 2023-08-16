package com.assessment.Springbootassessment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class Exception extends RuntimeException {
public Exception () {
	super("Failed");
}

}
