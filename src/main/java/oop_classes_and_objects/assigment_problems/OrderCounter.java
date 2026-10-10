package oop_classes_and_objects.assigment_problems;

class Order {
    // Key idea: a static field is shared by the whole class, so every constructor call bumps one counter.
    static int totalOrders = 0;

    Order() {
        totalOrders++;
    }
}

public class OrderCounter {
    public static void main(String[] args) {
        new Order();
        new Order();
        new Order();
        new Order();
        System.out.println("Total orders: " + Order.totalOrders);
    }
}
