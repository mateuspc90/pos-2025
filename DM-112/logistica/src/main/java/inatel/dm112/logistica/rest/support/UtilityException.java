package inatel.dm112.logistica.rest.support;

public class UtilityException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public UtilityException(String message) {
        super(message);
    }
    
    public UtilityException(String message, Throwable cause) {
        super(message, cause);
    }
}