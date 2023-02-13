package barista.matic.enums;

public enum IngredientPriceEnum {
    DECAFCOFFEE("ABC", 0.75), SUGAR("ABC", 0.25),
    CREAM("ABC", 0.25), COCOA("ABC", 0.90),
    ESPRESSO("ABC", 1.10), FOAMEDMILK("ABC", 0.35),
    STEAMEDMILK("ABC", 0.35), WHIPPEDCREAM("ABC", 1.00),
    COFFEE("aaa", 0.75);


    private final String name;
    private final Double price;

    private IngredientPriceEnum(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double getprice() {
        return this.price;
    }

}
