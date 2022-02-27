package domain;

public class InvalidMatchAttempt extends RuntimeException {
    public InvalidMatchAttempt (String message) {
        super(message);
    }
}
