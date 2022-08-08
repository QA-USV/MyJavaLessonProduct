package ru.netology.MyJavaLessonProduct;

import org.junit.jupiter.api.Test;

class ProductManagerTest {

    ProductRepository repo = new ProductRepository();

    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Black&White", 999, "Smith Jr.");
    Product book2 = new Book(2, "More Green Less White", 888, "John Wood");
    Product book3 = new Book(3, "White Apple", 777, "Lost Miner");
    Product book4 = new Book(4, "Black&Blue", 666, "Sam Rainbow");
    Product smartphone1 = new Smartphone(5, "Mate 99 Pro", 79_999, "Huawei");
    Product smartphone2 = new Smartphone(6, "Mate 20 Pro", 49_999, "Huawei");
    Product smartphone3 = new Smartphone(7, "Iphone 12 Pro", 99_999, "Apple");
    Product smartphone4 = new Smartphone(8, "Iphone 13 Pro Max", 159_999, "Apple");

    @Test
    public void shouldSeachByText() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] expected = {book3, smartphone3, smartphone4};
        Product[] actual = manager.searchBy("Apple");
    }
}