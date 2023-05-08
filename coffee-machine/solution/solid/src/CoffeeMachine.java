package solid;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {

    private final Map<IngredientType, Integer> ingredients = new HashMap<>();

    public CoffeeMachine(int waterLevel, int coffeeBeansLevel) {
        this.ingredients.put(IngredientType.WATER, waterLevel);
        this.ingredients.put(IngredientType.COFFEE_BEAN, coffeeBeansLevel);
    }

    public void makeDrink(Drink drink) {
        if (drink.areIngredientsEnough(ingredients)) {
            drink.getIngredients().forEach(this::subtractIngredient);
        } else {
            throw new NotEnoughIngredientsException();
        }
    }

    public void addIngredient(IngredientType ingredient, int quantity) {
        var initialQuantityForIngredient = this.ingredients.getOrDefault(ingredient, 0);
        this.ingredients.put(ingredient, initialQuantityForIngredient + quantity);
    }

    protected void subtractIngredient(IngredientType ingredient, int quantity) {
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
