package p;

public class CheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing a cheese pizza: tomato sauce and mozzarella on thin dough");
    }

    @Override
    public void bake() {
        System.out.println("Baking a cheese pizza at 550 F for 10 minutes");
    }

    @Override
    public void cut() {
        System.out.println("Cutting a cheese pizza into 8 slices");
    }

    @Override
    public void box() {
        System.out.println("Boxing a cheese pizza");
    }
}
