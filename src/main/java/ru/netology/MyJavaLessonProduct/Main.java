package ru.netology.MyJavaLessonProduct;

public class Main {

    public static void main(String[] args) {
        Product book1 = new Book(
                001,
                "Black&White",
                999,
                "Smith Jr."
        );

        Product book2 = new Book(
                002,
                "More Green Less White",
                888,
                "John Wood"
        );

        Product book3 = new Book(
                003,
                "White Apple",
                777,
                "Lost Miner"
        );

        Product book4 = new Book(
                004,
                "Black&Blue",
                666,
                "Sam Rainbow"
        );

        Product smartphone1 = new Smartphone(
                001,
                "Mate 99 Pro",
                79_999,
                "Huawei"
        );

        Product smartphone2 = new Smartphone(
                002,
                "Mate 20 Pro",
                49_999,
                "Huawei"
        );
        Product smartphone3 = new Smartphone(
                003,
                "Iphone 12 Pro",
                99_999,
                "Apple"
        );
        Product smartphone4 = new Smartphone(
                004,
                "Iphone 13 Pro Max",
                159_999,
                "Apple"
        );
    }
}
