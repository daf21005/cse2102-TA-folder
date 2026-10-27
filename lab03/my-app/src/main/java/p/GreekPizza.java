package p;

public class GreekPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing a Greek pizza: feta, olives, red onion and spinach");
    }

    @Override
    public void bake() {
        System.out.println("Baking a Greek pizza at 475 F for 18 minutes in an oiled pan");
    }

    @Override
    public void cut() {
        System.out.println("Cutting a Greek pizza into 8 wedges");
    }

    @Override
    public void box() {
        System.out.println("Boxing a Greek pizza");
    }
}
