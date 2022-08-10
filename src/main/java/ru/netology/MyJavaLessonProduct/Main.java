package ru.netology.MyJavaLessonProduct;

import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book1 = new Book(1, "Book001", 999, "Author000");
        Product book2 = new Book(2, "Book002", 888, "Author111");
        Product book3 = new Book(3, "Book003", 777, "Author222");
        Product book4 = new Book(4, "Book004", 666, "Author222");
        Product book5 = new Book(0, "Book005", 555, "Author000");
        Product book6 = new Book(-1, "Book006", 444, "Author333");
        Product smartphone1 = new Smartphone(5, "Mate 99", 79_999, "Huawei");
        Product smartphone2 = new Smartphone(6, "Iphone 11", 49_999, "Apple");
        Product smartphone3 = new Smartphone(7, "Iphone 12", 99_999, "Apple");
        Product smartphone4 = new Smartphone(8, "Iphone 13", 159_999, "Apple");

        try {
            repo.save(book1);
            repo.save(book2);
            repo.removeById(2);
            repo.removeById(3);
        } catch (NotFoundException s) {
            System.out.println(s);
        }

        try {
            repo.save(book6);
        } catch (NotFoundException s) {
            System.out.println(s);
        }

    }
}
