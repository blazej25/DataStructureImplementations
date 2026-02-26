package CustomExceptions;

public class EmptyListException extends Exception {

    public EmptyListException() {
        super("The list is empty");
    }

    public EmptyListException(String m) {
        super(m);
    }
}
