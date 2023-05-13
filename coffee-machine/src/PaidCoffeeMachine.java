
import java.util.Map;

public class PaidCoffeeMachine implements DrinkMachine {
    private final DrinkMachineImpl drinkMachine;

    long userCredit; // cents

    public PaidCoffeeMachine(DrinkMachineImpl drinkMachine) {
        this.drinkMachine = drinkMachine;
    }

    public long getUserCredit() {
        return this.userCredit;
    }

    public void insertCoins(long amount) {
        this.userCredit += amount;
    }

    @Override
    public void makeDrink(Drink drink) {
        if(!creditIsSufficient()) {
            throw new NotEnoughCreditException(getCoffeeCost(), this.userCredit);
        }

        drinkMachine.makeDrink(drink);
        this.userCredit -= getCoffeeCost();
    }

    @Override
    public void addIngredient(IngredientType ingredient, int quantity) {
        drinkMachine.addIngredient(ingredient, quantity);
    }

    @Override
    public Map<IngredientType, Integer> getAvailableIngredients() {
        return drinkMachine.getAvailableIngredients();
    }

    protected long getCoffeeCost() {
        return 50;
    }

    private boolean creditIsSufficient() {
        return userCredit >= getCoffeeCost();
    }
}