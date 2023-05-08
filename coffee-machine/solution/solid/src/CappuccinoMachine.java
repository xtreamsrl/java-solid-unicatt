package solid;


class CappuccinoMachine extends CoffeeMachine {
    CappuccinoMachine(int waterLevel, int coffeeBeansLevel, int milkLevel) {
        super(waterLevel, coffeeBeansLevel);
        this.addIngredient(IngredientType.MILK, milkLevel);
    }

    @Override
    protected boolean canMakeDrink() {
        return this.getQuantity(IngredientType.WATER) >= 100 &&
                this.getQuantity(IngredientType.COFFEE_BEAN) >= 20 &&
                this.getQuantity(IngredientType.MILK) >= 50;
    }

    public void makeCappuccino() {
        if (canMakeDrink()) {
            this.subtractIngredient(IngredientType.WATER, 100);
            this.subtractIngredient(IngredientType.COFFEE_BEAN, 20);
            this.subtractIngredient(IngredientType.MILK, 50);
        } else {
            throw new NotEnoughIngredientsException();
        }
    }

}
