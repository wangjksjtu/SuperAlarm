package basic_class;

public class NotExistException extends Exception {
    public NotExistException() {
        super("The items isn't existed!");
    }
}
