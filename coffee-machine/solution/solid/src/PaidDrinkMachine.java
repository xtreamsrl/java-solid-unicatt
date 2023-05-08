package solid;

import java.util.Map;

public class PaidDrinkMachine implements DrinkMachine {
    private final DrinkMachineImpl drinkMachine;

    long availableChange; // cents
    long userCredit; // cents

    public PaidDrinkMachine(DrinkMachineImpl drinkMachine, long availableChange) {
        this.drinkMachine = drinkMachine;
        this.availableChange = availableChange;
    }

    protected long getCoffeeCost() {
        return 50;
    }

    protected boolean creditIsSufficient() {
        return userCredit >= getCoffeeCost();
    }

    public long getUserCredit() {
        return this.userCredit;
    }


    public void insertCoins(long amount) {
        this.setUserCredit(this.userCredit += amount);
        this.availableChange += amount;
    }

    public void setUserCredit(long userCredit) {
        if(userCredit < 0) {
            throw new IllegalArgumentException("User credit must be greater than zero");
        }
        this.userCredit = userCredit;
    }

    @Override
    public void makeDrink(Drink drink) {
        if(!creditIsSufficient()) {
            throw new NotEnoughCreditException(getCoffeeCost(), this.userCredit);
        }

        drinkMachine.makeDrink(drink);
        this.setUserCredit(this.userCredit - getCoffeeCost());
        this.availableChange -= getCoffeeCost();
    }

    @Override
    public void addIngredient(IngredientType ingredient, int quantity) {
       drinkMachine.addIngredient(ingredient, quantity);
    }

    @Override
    public Map<IngredientType, Integer> getAvailableIngredients() {
        return drinkMachine.getAvailableIngredients();
    }

}
