package barista.matic.services;

import barista.matic.enums.IngredientsEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Recipe {

    private Map<String, Integer> recipe;
    public final String name;
    private double cost;

    protected Inventory inventory;

    public Recipe(String name, Inventory inventory) {
        this.inventory = inventory;
        this.name = name;
        recipe = new HashMap<>();
        setRecipe();
        cost = cost();
    }

    public double getCost() {
        return cost;
    }

    public void addIngredient(String ingredient, int qty) {
        recipe.put(ingredient, qty);
    }

    public abstract void setRecipe();

    public void dispenseCoffee() {
        System.err.println("Dispensing: " + name);
    }

    public void outOfStock() {
        System.err.println("Out of Stock: " + name);
    }

    public BaristaDrink makeDrink() {
        BaristaDrink baristaDrink;
        if (isInStock()) {
            baristaDrink = new BaristaDrink(name);
            for (Entry<String, Integer> ingredient : recipe.entrySet()) {
                for (int i = 0; i < ingredient.getValue(); i++) {
                    baristaDrink = inventory.get(ingredient.getKey()).addTo(baristaDrink);
                }
            }
            dispenseCoffee();
            return baristaDrink;
        } else {
            outOfStock();
            return null;
        }
    }

    public boolean isInStock() {
        for (Entry<String, Integer> ingredient : recipe.entrySet()) {
            if (!inventory.enoughOf(ingredient.getKey(), ingredient.getValue())) {
                return false;
            }
        }
        return true;
    }

    public Double cost() {
        Double cost = 0.0;
        for (Entry<String, Integer> ingredient : recipe.entrySet()) {
            for (int i = 0; i < ingredient.getValue(); i++) {
                cost += inventory.getCost(ingredient.getKey());
            }
        }
        return cost;
    }

}

class CoffeeRecipe extends Recipe {

    public CoffeeRecipe(Inventory inventory) {
        super("Coffee", inventory);
    }

    @Override
    public void setRecipe() {
        addIngredient(IngredientsEnum.Coffee.toString(), 3);
        addIngredient(IngredientsEnum.Sugar.toString(), 1);
        addIngredient(IngredientsEnum.Cream.toString(), 1);
    }

}

class DecafCoffeeRecipe extends Recipe {

    public DecafCoffeeRecipe(Inventory inventory) {
        super("Decaf Coffee", inventory);
    }

    @Override
    public void setRecipe() {
        addIngredient(IngredientsEnum.DecafCoffee.toString(), 3);
        addIngredient(IngredientsEnum.Sugar.toString(), 1);
        addIngredient(IngredientsEnum.Cream.toString(), 1);
    }

}

class CaffeLatteRecipe extends Recipe {

    public CaffeLatteRecipe(Inventory inventory) {
        super("Caffe Latte", inventory);
    }

    @Override
    public void setRecipe() {
        addIngredient(IngredientsEnum.Espresso.toString(), 2);
        addIngredient(IngredientsEnum.SteamedMilk.toString(), 1);
    }

}

class CaffeAmericanoRecipe extends Recipe {

    public CaffeAmericanoRecipe(Inventory inventory) {
        super("Caffe Americano", inventory);
    }

    @Override
    public void setRecipe() {
        addIngredient(IngredientsEnum.Espresso.toString(), 3);
    }

}

class CaffeMochaRecipe extends Recipe {

    public CaffeMochaRecipe(Inventory inventory) {
        super("Caffe Mocha", inventory);
    }

    @Override
    public void setRecipe() {
        addIngredient(IngredientsEnum.Espresso.toString(), 1);
        addIngredient(IngredientsEnum.Cocoa.toString(), 1);
        addIngredient(IngredientsEnum.SteamedMilk.toString(), 1);
        addIngredient(IngredientsEnum.WhippedCream.toString(), 1);
    }

}

class CappuccinoRecipe extends Recipe {

    public CappuccinoRecipe(Inventory inventory) {
        super("Cappuccino", inventory);
    }

    @Override
    public void setRecipe() {
        addIngredient(IngredientsEnum.Espresso.toString(), 2);
        addIngredient(IngredientsEnum.SteamedMilk.toString(), 1);
        addIngredient(IngredientsEnum.FoamedMilk.toString(), 1);
    }

}
