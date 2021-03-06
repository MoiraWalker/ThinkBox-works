package nl.walker.novi.thinkbox.exception;

public class DatabaseErrorException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DatabaseErrorException() {
        super("Problem in database");
    }
}
