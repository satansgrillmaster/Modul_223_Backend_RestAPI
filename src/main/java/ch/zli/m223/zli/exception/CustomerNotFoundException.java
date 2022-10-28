package ch.zli.m223.zli.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Customer not found")
public class CustomerNotFoundException extends NotraceException {}