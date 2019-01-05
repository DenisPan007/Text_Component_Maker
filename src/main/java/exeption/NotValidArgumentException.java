package exeption;

public class NotValidArgumentException extends Exception {
    public NotValidArgumentException(){
    }
    public NotValidArgumentException(String message){
        super(message);
    }
    public NotValidArgumentException(Throwable cause){
        super(cause);
    }
    public NotValidArgumentException(String message, Throwable cause){
        super(message,cause);
    }

}
