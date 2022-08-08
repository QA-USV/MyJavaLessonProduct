package ru.netology.MyJavaLessonProduct;

public class Smartphone extends Product {
    private String name;
    private String producer;

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.name = name;
        this.producer = producer;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}