import java.util.Map;

public interface DrinkMachine {
    void makeDrink(Drink drink);

    void addIngredient(IngredientType ingredient, int quantity);

    Map<IngredientType, Integer> getAvailableIngredients();
}