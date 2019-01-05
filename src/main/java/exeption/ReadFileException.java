package exeption;

public class ReadFileException extends Exception{
    public ReadFileException(){
    }
    public ReadFileException(String message){
        super(message);
    }
    public ReadFileException(Throwable cause){
        super(cause);
    }
    public ReadFileException(String message, Throwable cause){
        super(message,cause);
    }

}
