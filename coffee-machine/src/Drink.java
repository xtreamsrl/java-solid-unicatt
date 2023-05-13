import java.util.Map;

public abstract class Drink {
    private final Map<IngredientType, Integer> requiredIngredients;

    public Drink(Map<IngredientType, Integer> requiredIngredients) {
        this.requiredIngredients = requiredIngredients;
    }

    public Map<IngredientType, Integer> getIngredients() {
        return Map.copyOf(requiredIngredients);
    }

    abstract boolean areIngredientsEnough(Map<IngredientType, Integer> availableIngredients);

    protected int getQuantity(IngredientType ingredient) {
        return this.requiredIngredients.getOrDefault(ingredient, 0);
    }
}