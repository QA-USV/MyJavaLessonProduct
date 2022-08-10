package ru.netology.MyJavaLessonProduct;

public class ProductRepository {

    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        if (findById(product.id) != null) {
            throw new AlreadyExistsException(
                    "Product with id: " + product.getId() + " already exist."
            );
        }
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found."
            );
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
            products = tmp;
        }
    }
}
