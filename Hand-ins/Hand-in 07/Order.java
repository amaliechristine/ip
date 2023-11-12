import java.util.ArrayList;
import java.util.List;

public class Order {
    
    protected List<Food> ordered;
    protected int totalPrice;

    public Order() {
        ordered = new ArrayList<>();
    }

    public void addFood(Food food) {
        ordered.add(food);
    }

    public int total() {
        totalPrice = 0;
        for (Food food : ordered) {
            totalPrice = totalPrice + food.getPrice();
        }
        return totalPrice;
    }

    public boolean payWith(CreditCard card) {
        boolean withdrawBoolean = card.withdraw(total());
        if (withdrawBoolean==false) {
            System.out.println("ERROR: Payment failed");
        }
        return withdrawBoolean;
    }

    public void display() {
        for (Food food : ordered) {
                food.display();
                total();
                System.out.println();
        }
        System.out.println(totalPrice + " kr TOTAL");
    }
}
