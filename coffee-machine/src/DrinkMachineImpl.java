import java.util.HashMap;
import java.util.Map;

public class DrinkMachineImpl implements DrinkMachine {
    private final Map<IngredientType, Integer> ingredients = new HashMap<>();

    @Override
    public void makeDrink(Drink drink) {
        if (drink.areIngredientsEnough(ingredients)) {
            drink.getIngredients().forEach(this::subtractIngredient);
        } else {
            throw new NotEnoughIngredientsException();
        }
    }

    @Override
    public void addIngredient(IngredientType ingredient, int quantity) {
        var initialQuantityForIngredient = this.ingredients.getOrDefault(ingredient, 0);
        this.ingredients.put(ingredient, initialQuantityForIngredient + quantity);
    }

    @Override
    public Map<IngredientType, Integer> getAvailableIngredients() {
        return Map.copyOf(this.ingredients);
    }

    private void subtractIngredient(IngredientType ingredient, int quantity) {
        var initialQuantityForIngredient = this.ingredients.getOrDefault(ingredient, 0);
        if (initialQuantityForIngredient < quantity) {
            throw new IllegalStateException("Cannot subtract " + quantity + "from ingredient " + ingredient + " " + initialQuantityForIngredient);
        }
        this.ingredients.put(ingredient, initialQuantityForIngredient - quantity);
    }

}