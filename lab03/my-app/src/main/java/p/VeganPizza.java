package p;

public class VeganPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing a vegan pizza: dairy-free cheese and seasonal vegetables");
    }

    @Override
    public void bake() {
        System.out.println("Baking a vegan pizza at 500 F for 12 minutes");
    }

    @Override
    public void cut() {
        System.out.println("Cutting a vegan pizza into 8 slices");
    }

    @Override
    public void box() {
        System.out.println("Boxing a vegan pizza");
    }
}
