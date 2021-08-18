package Bicycle;

public class CustomException extends Exception{

    //define a simple constructor
    public CustomException(String message){
        super(message); //pass our own message to the super constructor class
    }

    public CustomException(Throwable cause){
        super(cause);
    }

    public CustomException(String message, Throwable cause){
        super(message, cause);
    }






}
