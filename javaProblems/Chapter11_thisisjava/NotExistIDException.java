package javaProblems.Chapter11_thisisjava;

public class NotExistIDException extends Exception{
    public NotExistIDException(){}
    public NotExistIDException(String msg){
        super(msg);
    }
}
