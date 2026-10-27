package p;

import java.util.Scanner;

public class PizzaStore {

    private final PizzaFactory factory;

    public PizzaStore(PizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(PizzaType type) {
        Pizza pizza = factory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    public static void main(String[] args) {
        PizzaStore store = new PizzaStore(new PizzaFactory());
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome! We make: Cheese, Greek, Pepperoni, Gluten-Free, Vegan");
        while (true) {
            System.out.print("Your order (or 'quit'): ");
            if (!input.hasNextLine()) {
                break;
            }
            String line = input.nextLine();
            if (line.trim().equalsIgnoreCase("quit")) {
                break;
            }
            PizzaType type = PizzaType.fromText(line);
            if (type == null) {
                System.out.println("Sorry, we don't make \"" + line.trim() + "\". Please try again.");
                continue;
            }
            store.orderPizza(type);
        }
        input.close();
        System.out.println("Thanks for visiting!");
    }
}
