package oop_classes_and_objects.assigment_problems;

class Product {
    String productId;
    String productName;

    // Key idea: "this.x = x" separates the field from the same-named parameter.
    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
}

public class ProductConstructorDemo {
    public static void main(String[] args) {
        Product product = new Product("P-1042", "Wireless Mouse");
        System.out.println(product.productId + " - " + product.productName);
    }
}
