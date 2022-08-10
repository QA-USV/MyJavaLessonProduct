package ru.netology.MyJavaLessonProduct;

public class Book extends Product {
    //    private String name;
    private String author;

    ProductRepository repo = new ProductRepository();

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

//    public String getAuthor() {
//        return author;
//    }

//    public void setAuthor(String author) {
//        this.author = author;
//    }
}