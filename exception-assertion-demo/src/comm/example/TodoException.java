package comm.example;

public class TodoException extends RuntimeException{
    private String message;

    public TodoException(String message) {

        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
