package ru.netology.MyJavaLessonProduct;

public class Smartphone extends Product {
//    private String name;
    private String producer;

    ProductRepository repo = new ProductRepository();

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

//    public String getProducer() {
//        return producer;
//    }
//
//    public void setProducer(String producer) {
//        this.producer = producer;
//    }
}