package by.overone.bibliophile.dao.exception;

public class DAONotFoundException extends Exception {
    public DAONotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAONotFoundException(String message) {
        super(message);
    }
}
