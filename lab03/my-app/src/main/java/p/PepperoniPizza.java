package p;

public class PepperoniPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing a pepperoni pizza: tomato sauce, mozzarella and pepperoni");
    }

    @Override
    public void bake() {
        System.out.println("Baking a pepperoni pizza at 550 F for 11 minutes");
    }

    @Override
    public void cut() {
        System.out.println("Cutting a pepperoni pizza into 8 slices");
    }

    @Override
    public void box() {
        System.out.println("Boxing a pepperoni pizza");
    }
}
