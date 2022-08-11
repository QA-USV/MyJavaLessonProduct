package ru.netology.MyJavaLessonProduct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
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

    @Test
    public void shouldSaveNewProducts() {

        repo.save(book1);
        repo.save(book2);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone3);
        repo.save(smartphone4);

        Product[] expected = {book1, book2, book4, smartphone1, smartphone3, smartphone4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveTheSameIdProducts() {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.save(book2));
    }

    @Test
    public void shouldNotSaveZeroAndNegativeId() {

        repo.save(book1);
        repo.save(book4);

        Assertions.assertThrows(UnacceptableException.class, () -> repo.save(book5));
        Assertions.assertThrows(UnacceptableException.class, () -> repo.save(book6));
    }

    @Test
    public void shouldRemoveById() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.removeById(2);
        repo.removeById(8);

        Product[] expected = {book1, book3, book4, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAlarmAboutRemovingPositiveFakeId() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(10));
    }

    @Test
    public void shouldAlarmAboutRemovingNegativeFakeId() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(-10));
    }

    @Test
    public void shouldGetAll() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetAllWhenNothing() {
        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findById() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);

        Product[] expected = {book2};
        Product actual = repo.findById(2);

        Assertions.assertArrayEquals(expected, new Product[]{actual});
    }
}