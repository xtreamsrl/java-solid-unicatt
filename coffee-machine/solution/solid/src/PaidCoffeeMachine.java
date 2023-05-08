package solid;

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
        this.setUserCredit(this.userCredit += amount);
    }

    @Override
    public void makeDrink(Drink drink) {
        if(!creditIsSufficient()) {
            throw new NotEnoughCreditException(getCoffeeCost(), this.userCredit);
        }

        drinkMachine.makeDrink(drink);
        this.setUserCredit(this.userCredit - getCoffeeCost());
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

    private void setUserCredit(long userCredit) {
        if(userCredit < 0) {
            throw new IllegalArgumentException("User credit must be greater than zero");
        }
        this.userCredit = userCredit;
    }
}
