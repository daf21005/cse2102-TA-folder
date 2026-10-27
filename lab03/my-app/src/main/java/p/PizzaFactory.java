package p;

public class PizzaFactory {

    public Pizza createPizza(PizzaType type) {
        if (type == null) {
            throw new IllegalArgumentException("pizza type must not be null");
        }
        switch (type) {
            case CHEESE:
                return new CheesePizza();
            case GREEK:
                return new GreekPizza();
            case PEPPERONI:
                return new PepperoniPizza();
            case GLUTEN_FREE:
                return new GlutenFreePizza();
            case VEGAN:
                return new VeganPizza();
            default:
                throw new IllegalArgumentException("no pizza available for " + type);
        }
    }
}
