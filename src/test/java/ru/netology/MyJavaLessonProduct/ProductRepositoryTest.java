package ru.netology.MyJavaLessonProduct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.MyJavaLessonProduct.ProductRepository;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    Product book1 = new Book(1, "Black&White",999,"Smith Jr.");
    Product book2 = new Book(2, "More Green Less White",888,"John Wood");
    Product book3 = new Book(3, "White Apple",777,"Lost Miner");
    Product book4 = new Book(4, "Black&Blue", 666, "Sam Rainbow");
    Product smartphone1 = new Smartphone(5,"Mate 99 Pro",79_999,"Huawei");
    Product smartphone2 = new Smartphone(6,"Mate 20 Pro",49_999,"Huawei");
    Product smartphone3 = new Smartphone(7,"Iphone 12 Pro",99_999,"Apple");
    Product smartphone4 = new Smartphone(8,"Iphone 13 Pro Max",159_999,"Apple");

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
        Product[] expected = {book1, book3, book4, smartphone1, smartphone2, smartphone3, smartphone4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}