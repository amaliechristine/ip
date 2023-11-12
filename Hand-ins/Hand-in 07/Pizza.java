import java.util.ArrayList;
import java.util.List;

public class Pizza extends Food {
   
    protected List<String> toppings;

    public Pizza() {
        super("Pizza", 45);
        toppings = new ArrayList<>();
    }

    public void addTopping(String topping) {
        toppings.add(topping);
        price = price + 10;
    }

    public void setName(String name) {
        super.name = name;
    }

    public void display() {
        super.display();
        String separator = "";
        
        if (!toppings.isEmpty()) {
            System.out.print(" { ");
            for (String topping : toppings){
                System.out.print(separator);
                System.out.print(topping);
                separator = ", ";
            }
        } else {
            System.out.print(" {");
        }
        System.out.print(" }");
    }
    
}
