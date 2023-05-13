import java.util.Map;

public class Coffee extends Drink {

    public Coffee() {
        super(Map.of(IngredientType.WATER, 50, IngredientType.COFFEE_BEAN, 20));
    }

    @Override
    boolean areIngredientsEnough(Map<IngredientType, Integer> availableIngredients) {
        return availableIngredients.getOrDefault(IngredientType.WATER, 0 ) >= this.getQuantity(IngredientType.WATER) &&
                availableIngredients.getOrDefault(IngredientType.COFFEE_BEAN, 0 ) >= this.getQuantity(IngredientType.COFFEE_BEAN);
    }
}