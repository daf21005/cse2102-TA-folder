package p;

public enum PizzaType {
    CHEESE,
    GREEK,
    PEPPERONI,
    GLUTEN_FREE,
    VEGAN;

    public static PizzaType fromText(String text) {
        if (text == null) {
            return null;
        }
        String key = text.replaceAll("[\\s_-]", "");
        if (key.isEmpty()) {
            return null;
        }
        if (key.equalsIgnoreCase("peperoni")) {
            return PEPPERONI;
        }
        for (PizzaType type : values()) {
            if (type.name().replace("_", "").equalsIgnoreCase(key)) {
                return type;
            }
        }
        return null;
    }
}
