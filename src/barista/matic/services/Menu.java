package barista.matic.services;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Menu {

    private Map<String, Recipe> recipes;

    public Menu(Inventory inventory) {
        recipes = new TreeMap<>();
        addRecipe(new DecafCoffeeRecipe(inventory));
        addRecipe(new CaffeAmericanoRecipe(inventory));
        addRecipe(new CaffeLatteRecipe(inventory));
        addRecipe(new CaffeMochaRecipe(inventory));
        addRecipe(new CappuccinoRecipe(inventory));
        addRecipe(new CoffeeRecipe(inventory));
    }

    public void addRecipe(Recipe recipe) {
        if (recipes.containsKey(recipe.name)) {
            throw new RuntimeException();
        } else {
            recipes.put(recipe.name, recipe);
        }
    }

    public void display() {
        System.out.println("Menu:");
        int i = 0;
        for (Entry<String, Recipe> recipe : recipes.entrySet()) {
            String price = String.format("%.2f", recipe.getValue().getCost());
            System.out.println((i + 1) + "," + recipe.getKey() + "," + "$" + price + "," + recipe.getValue().isInStock());
            i++;
        }
    }

    public BaristaDrink makeDrink(int index) {
        if (index < recipes.size()) {
            Iterator<Recipe> it = recipes.values().iterator();
            for (int i = 0; i < index; i++) {
                it.next();
            }
            return it.next().makeDrink();
        } else {
//        System.out.println(index + "  " + recipes.size());
            throw new IndexOutOfBoundsException();
        }
    }

}

