package p;

import p.CheesePizza;
import p.GlutenFreePizza;
import p.GreekPizza;
import p.PepperoniPizza;
import p.Pizza;
import p.PizzaFactory;
import p.PizzaType;
import p.VeganPizza;

import org.junit.Test;

import static org.junit.Assert.*;

public class PizzaFactoryTest {

    private final PizzaFactory factory = new PizzaFactory();

    @Test
    public void cheese_givesCheesePizza() {
        assertTrue(factory.createPizza(PizzaType.CHEESE) instanceof CheesePizza);
    }

    @Test
    public void greek_givesGreekPizza() {
        assertTrue(factory.createPizza(PizzaType.GREEK) instanceof GreekPizza);
    }

    @Test
    public void pepperoni_givesPepperoniPizza() {
        assertTrue(factory.createPizza(PizzaType.PEPPERONI) instanceof PepperoniPizza);
    }

    @Test
    public void glutenFree_givesGlutenFreePizza() {
        assertTrue(factory.createPizza(PizzaType.GLUTEN_FREE) instanceof GlutenFreePizza);
    }

    @Test
    public void vegan_givesVeganPizza() {
        assertTrue(factory.createPizza(PizzaType.VEGAN) instanceof VeganPizza);
    }

    @Test
    public void everyType_givesANonNullPizza() {
        for (PizzaType type : PizzaType.values()) {
            Pizza pizza = factory.createPizza(type);
            assertNotNull("no pizza for " + type, pizza);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_isRejectedWithAClearError() {
        factory.createPizza(null);
    }
}
