package p;

import p.Pizza;
import p.PizzaFactory;
import p.PizzaStore;
import p.PizzaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class PizzaStoreTest {

    /** A pizza that records each step into a shared log instead of printing. */
    static class RecordingPizza implements Pizza {
        private final List<String> log;

        RecordingPizza(List<String> log) {
            this.log = log;
        }

        @Override
        public void prepare() {
            log.add("prepare");
        }

        @Override
        public void bake() {
            log.add("bake");
        }

        @Override
        public void cut() {
            log.add("cut");
        }

        @Override
        public void box() {
            log.add("box");
        }
    }

    /** A factory that remembers what was asked for and what it made. */
    static class RecordingFactory extends PizzaFactory {
        final List<String> log = new ArrayList<>();
        PizzaType requested;
        Pizza made;

        @Override
        public Pizza createPizza(PizzaType type) {
            requested = type;
            made = new RecordingPizza(log);
            return made;
        }
    }

    @Test
    public void orderPizza_runsFourStepsInOrder() {
        RecordingFactory factory = new RecordingFactory();
        new PizzaStore(factory).orderPizza(PizzaType.CHEESE);
        assertEquals(Arrays.asList("prepare", "bake", "cut", "box"), factory.log);
    }

    @Test
    public void orderPizza_asksTheFactoryForTheRequestedType() {
        RecordingFactory factory = new RecordingFactory();
        new PizzaStore(factory).orderPizza(PizzaType.GREEK);
        assertEquals(PizzaType.GREEK, factory.requested);
    }

    @Test
    public void orderPizza_returnsTheSamePizzaTheFactoryMade() {
        RecordingFactory factory = new RecordingFactory();
        Pizza returned = new PizzaStore(factory).orderPizza(PizzaType.VEGAN);
        assertSame(factory.made, returned);
    }

    @Test(expected = IllegalArgumentException.class)
    public void orderPizza_withNullType_throws() {
        new PizzaStore(new PizzaFactory()).orderPizza(null);
    }
}
