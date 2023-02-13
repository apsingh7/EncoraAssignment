package barista.matic.Ingredients;

import barista.matic.services.BaristaDrink;
import barista.matic.enums.IngredientsEnum;

public class Ingredients extends BaristaDrink {
    private BaristaDrink baristaDrink;
    private Double price;

    private IngredientsEnum items;

    public Ingredients(String name, Double price) {
        super(name);
        this.price = price;
    }

    public String getDetails() {
        return baristaDrink.getDetails();
    }

    public String getName() {
        return super.getDetails();
    }

    public BaristaDrink addTo(BaristaDrink baristaDrink) {
        this.baristaDrink = baristaDrink;
        return this;
    }

    @Override
    public Double price() {
        if (baristaDrink != null) {
            return price + baristaDrink.price();
        } else {
            return price;
        }
    }

}
