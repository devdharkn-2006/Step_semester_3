package encapsulation.assigment_problems;

// Key idea: prices stay private; only the total and count are exposed, and the total is
// computed on demand so it can never go stale.
class Cart {
    private final String cartId;
    private final int[] prices;
    private int itemCount = 0;

    Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new int[maxItems];
    }

    void addItem(int price) {
        if (itemCount == prices.length) {
            System.out.println("Cart full, cannot add item priced " + price);
            return;
        }
        prices[itemCount++] = price;
    }

    int getTotal() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) total += prices[i];
        return total;
    }

    int getItemCount() {
        return itemCount;
    }

    String getCartId() {
        return cartId;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("cart.getTotal() -> " + cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}
