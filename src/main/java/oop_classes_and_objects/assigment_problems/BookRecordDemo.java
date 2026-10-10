package oop_classes_and_objects.assigment_problems;

// Key idea: a class bundles related fields; each object gets its own copy of them.
class Book {
    String title;
    double price;
}

public class BookRecordDemo {
    public static void main(String[] args) {
        Book book = new Book();
        book.title = "Clean Code";
        book.price = 650.0;
        System.out.println("Title: " + book.title + " | Price: Rs " + book.price);
    }
}
