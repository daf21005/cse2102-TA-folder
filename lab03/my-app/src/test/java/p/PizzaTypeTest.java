package p;

import p.PizzaType;

import org.junit.Test;

import static org.junit.Assert.*;

public class PizzaTypeTest {

    @Test
    public void enumNamesAndLabelsBothMatch() {
        assertEquals(PizzaType.CHEESE, PizzaType.fromText("CHEESE"));
        assertEquals(PizzaType.GLUTEN_FREE, PizzaType.fromText("GLUTEN_FREE"));
        assertEquals(PizzaType.GLUTEN_FREE, PizzaType.fromText("GlutenFree"));
    }

    @Test
    public void spacesAndHyphensAreIgnored() {
        assertEquals(PizzaType.GLUTEN_FREE, PizzaType.fromText("gluten free"));
        assertEquals(PizzaType.GLUTEN_FREE, PizzaType.fromText("Gluten-Free"));
    }

    @Test
    public void matchingIgnoresCase() {
        assertEquals(PizzaType.GREEK, PizzaType.fromText("gReEk"));
        assertEquals(PizzaType.VEGAN, PizzaType.fromText("vegan"));
    }

    @Test
    public void handoutSpellingOfPepperoniIsAccepted() {
        assertEquals(PizzaType.PEPPERONI, PizzaType.fromText("Peperoni"));
        assertEquals(PizzaType.PEPPERONI, PizzaType.fromText("pepperoni"));
    }

    @Test
    public void surroundingWhitespaceIsIgnored() {
        assertEquals(PizzaType.CHEESE, PizzaType.fromText("  cheese  "));
    }

    @Test
    public void unknownOrBlankTextGivesNull() {
        assertNull(PizzaType.fromText("pineapple"));
        assertNull(PizzaType.fromText(""));
        assertNull(PizzaType.fromText("   "));
        assertNull(PizzaType.fromText(null));
    }
}
