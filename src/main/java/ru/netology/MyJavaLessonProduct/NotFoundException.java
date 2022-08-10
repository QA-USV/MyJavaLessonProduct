package ru.netology.MyJavaLessonProduct;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String s) {
        super(s);
    }
}