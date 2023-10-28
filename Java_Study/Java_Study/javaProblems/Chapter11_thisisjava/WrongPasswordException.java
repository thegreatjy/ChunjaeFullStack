package javaProblems.Chapter11_thisisjava;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(){}
    public WrongPasswordException(String msg){
        super(msg);
    }
}
