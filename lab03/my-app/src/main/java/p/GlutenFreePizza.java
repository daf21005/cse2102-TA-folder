package p;

public class GlutenFreePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing a gluten-free pizza on a rice-flour crust, kept away from gluten");
    }

    @Override
    public void bake() {
        System.out.println("Baking a gluten-free pizza at 450 F for 14 minutes on a separate tray");
    }

    @Override
    public void cut() {
        System.out.println("Cutting a gluten-free pizza into 6 squares with a dedicated cutter");
    }

    @Override
    public void box() {
        System.out.println("Boxing a gluten-free pizza");
    }
}
