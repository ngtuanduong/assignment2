package a2_2201040036.utils;
/**
 * A run-time exception that is thrown by a method that could not
 * perform its operation due to input data errors.
 */
public class NotPossibleException extends RuntimeException {
    public NotPossibleException(String s) {
        super(s);
    }
}