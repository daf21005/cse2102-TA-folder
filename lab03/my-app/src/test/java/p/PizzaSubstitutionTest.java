package p;

import p.CheesePizza;
import p.GlutenFreePizza;
import p.Pizza;
import p.PizzaFactory;
import p.PizzaType;
import p.VeganPizza;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// Liskov Substitution: any Pizza can be used where a Pizza is expected, and
// every one of them honors the same four-step contract.
public class PizzaSubstitutionTest {

    private final ByteArrayOutputStream captured = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @Before
    public void captureOutput() {
        originalOut = System.out;
        System.setOut(new PrintStream(captured, true));
    }

    @After
    public void restoreOutput() {
        System.setOut(originalOut);
    }

    /** Runs the four steps through the Pizza interface only. */
    private static void runAllSteps(Pizza pizza) {
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    @Test
    public void everyPizzaType_printsExactlyOneLinePerStep() {
        PizzaFactory factory = new PizzaFactory();
        for (PizzaType type : PizzaType.values()) {
            captured.reset();
            runAllSteps(factory.createPizza(type));
            String[] lines = captured.toString().trim().split("\n");
            assertEquals("wrong number of lines for " + type, 4, lines.length);
        }
    }

    @Test
    public void pizzasOfDifferentTypes_areInterchangeableAsPizza() {
        Pizza cheese = new CheesePizza();
        Pizza glutenFree = new GlutenFreePizza();
        Pizza vegan = new VeganPizza();

        runAllSteps(cheese);
        runAllSteps(glutenFree);
        runAllSteps(vegan);

        String output = captured.toString();
        assertTrue(output.contains("cheese pizza"));
        assertTrue(output.contains("gluten-free pizza"));
        assertTrue(output.contains("vegan pizza"));
    }
}
