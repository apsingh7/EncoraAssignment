package barista.matic.services;


import barista.matic.Ingredients.*;
import barista.matic.enums.IngredientPriceEnum;

import java.util.*;

public class Inventory {

    private Map<String, Integer> quantities;
    private Map<String, Ingredients> ingredients;

    private List<String> ingredientsList = List.of("DecafCoffee", "Sugar", "Cream",
            "Cocoa", "Espresso", "FoamedMilk",
            "SteamedMilk", "WhippedCream", "Coffee");


    public Inventory() {
        ingredients = new HashMap<>();
        quantities = new TreeMap<>();
        loadIngredients();
    }

    public void display() {
//        System.out.println("Inventory:");
        Iterator<String> it1 = quantities.keySet().iterator();
        Iterator<Integer> it2 = quantities.values().iterator();
        while (it1.hasNext() && it2.hasNext()) {
            System.out.println(it1.next() + "," + it2.next());
        }
    }

    public void restock() {
        for (String ingredient : quantities.keySet()) {
            quantities.put(ingredient, 10);
        }
    }

    public void loadIngredients() {
        for (String ingredient : ingredientsList) {
            if (ingredients.containsKey(ingredient)) {
                throw new RuntimeException();
            } else {
                ingredients.put(ingredient, new Ingredients(ingredient, IngredientPriceEnum.valueOf(ingredient.toUpperCase()).getprice()));
                quantities.put(ingredient, 10);
            }
        }
    }

    public boolean enoughOf(String ingredient, int qty) {
        if (ingredients.containsKey(ingredient)) {
            if (quantities.get(ingredient) >= qty) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new RuntimeException(ingredient);
        }
    }

    public Ingredients get(String ingredient) {
//        System.out.println(ingredient);
        if (enoughOf(ingredient, 1)) {
            quantities.put(ingredient, quantities.get(ingredient) - 1);
            return ingredients.get(ingredient);
        } else {
            throw new RuntimeException();
        }
    }

    public Double getCost(String ingredient) {
//        System.out.println(ingredient);
        if (ingredients.containsKey(ingredient)) {
            return ingredients.get(ingredient).price();
        } else {
            throw new RuntimeException();
        }
    }
}
