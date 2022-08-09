package ru.netology.MyJavaLessonProduct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductManagerTest {

    ProductRepository repo = new ProductRepository();

    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Book001", 999, "Author000");
    Product book2 = new Book(2, "Book002", 888, "Author111");
    Product book3 = new Book(3, "Book003", 777, "Author222");
    Product book4 = new Book(4, "Book004", 666, "Author222");
    Product smartphone1 = new Smartphone(5, "Mate 99", 79_999, "Huawei");
    Product smartphone2 = new Smartphone(6, "Iphone 11", 49_999, "Apple");
    Product smartphone3 = new Smartphone(7, "Iphone 12", 99_999, "Apple");
    Product smartphone4 = new Smartphone(8, "Iphone 13", 159_999, "Apple");

    @BeforeEach
    public void addProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
    }

    @Test
    public void shouldAddProducts() {

        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3, smartphone4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByExactName() {

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Book002");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothing() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Samsung");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByTextInName() {

        Product[] expected = {book1, book2, book3, book4};
        Product[] actual = manager.searchBy("Book");

        Assertions.assertArrayEquals(expected, actual);
    }
}