package ch.zli.m223.zli.exception;

@SuppressWarnings("serial")
public class NotraceException extends RuntimeException {
    public NotraceException(){
        super("", null, true, false);
    }
}