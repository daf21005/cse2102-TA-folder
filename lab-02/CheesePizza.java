public class CheesePizza implements Pizza {

    public CheesePizza() {
        this.PizzaType = Pizza.CHEESE
    }

    public void prepare(){
        System.out.println("Preparing a CHEESE " + TranslatePizzaType.fromPizzaTypeEnumToString(thePizzaType));
    }

    public void bake(){
        System.out.println("Baking a CHEESE PIZZA")
    }


    public void cut() {
        // do stuff
    }

    public void box(){
        // do stuff
    }

}