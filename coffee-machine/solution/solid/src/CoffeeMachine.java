package solid;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {

    private final Map<IngredientType, Integer> ingredients = new HashMap<>();


    public CoffeeMachine(int waterLevel, int coffeeBeansLevel) {
        this.ingredients.put(IngredientType.WATER, waterLevel);
        this.ingredients.put(IngredientType.COFFEE_BEAN, coffeeBeansLevel);
    }

    protected boolean canMakeDrink() {
        return this.getQuantity(IngredientType.WATER) >= 50 && this.getQuantity(IngredientType.COFFEE_BEAN) >= 20;
    }

    public void makeCoffee() {
        if (canMakeDrink()) {
            this.subtractIngredient(IngredientType.WATER, 50);
            this.subtractIngredient(IngredientType.COFFEE_BEAN, 20);
        } else {
            throw new NotEnoughIngredientsException();
        }
    }


    public void addIngredient(IngredientType ingredient, int quantity) {
        var initialQuantityForIngredient = this.ingredients.getOrDefault(ingredient, 0);
        this.ingredients.put(ingredient, initialQuantityForIngredient + quantity);
    }

    public void subtractIngredient(IngredientType ingredient, int quantity) {
        var initialQuantityForIngredient = this.ingredients.getOrDefault(ingredient, 0);
        if (initialQuantityForIngredient < quantity) {
            throw new IllegalStateException("Cannot subtract " + quantity + "from ingredient " + ingredient + " " + initialQuantityForIngredient);
        }
        this.ingredients.put(ingredient, initialQuantityForIngredient - quantity);
    }

    public int getQuantity(IngredientType ingredient) {
        return this.ingredients.getOrDefault(ingredient, 0);
    }

}
