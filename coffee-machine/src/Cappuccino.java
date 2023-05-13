import java.util.Map;

public class Cappuccino extends Drink {
    public Cappuccino() {
        super(Map.of(IngredientType.WATER, 100, IngredientType.COFFEE_BEAN, 20, IngredientType.MILK, 50));
    }

    @Override
    boolean areIngredientsEnough(Map<IngredientType, Integer> availableIngredients) {
        return availableIngredients.getOrDefault(IngredientType.WATER, 0 ) >= this.getQuantity(IngredientType.WATER) &&
                availableIngredients.getOrDefault(IngredientType.COFFEE_BEAN, 0 ) >= this.getQuantity(IngredientType.COFFEE_BEAN) &&
                availableIngredients.getOrDefault(IngredientType.MILK, 0 ) >= this.getQuantity(IngredientType.MILK);
    }
}