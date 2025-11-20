public class AgeCheckingException extends RuntimeException {

    public String message;

    public AgeCheckingException(String message) {
        super(message);
    }
}
