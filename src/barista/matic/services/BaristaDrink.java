package barista.matic.services;

public class BaristaDrink {

    private String name;

    public BaristaDrink(String name) {
        this.name = name;
    }

    public String getDetails() {
        return name;
    }

    public Double price() {
        return 0.0;
    }

}
