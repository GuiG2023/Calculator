package calculator.evaluator;

public class InvalidTokenException extends Exception {
    public InvalidTokenException() {// how to use?
        super("*** Invalid Token *** : ");
    }

    public InvalidTokenException(String message) {
        super("*** Invalid Token *** : " + message);
    }
}
