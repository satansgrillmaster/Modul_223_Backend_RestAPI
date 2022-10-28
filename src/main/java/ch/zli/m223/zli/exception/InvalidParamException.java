package ch.zli.m223.zli.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Invalid Param")
public class InvalidParamException extends NotraceException {

}