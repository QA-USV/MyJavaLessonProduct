package ru.netology.MyJavaLessonProduct;

public class AlreadyExistsException extends RuntimeException{

    public AlreadyExistsException(String a){
        super(a);
    }
}
