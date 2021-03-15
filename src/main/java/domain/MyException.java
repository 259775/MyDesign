package domain;

public class MyException extends RuntimeException{
    public MyException(){

    }
    public MyException(String mes){
        super(mes);
    }

}