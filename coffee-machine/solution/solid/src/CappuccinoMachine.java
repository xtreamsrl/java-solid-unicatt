package solid;


class CappuccinoMachine extends CoffeeMachine {
    CappuccinoMachine(int waterLevel, int coffeeBeansLevel, int milkLevel) {
        super(waterLevel, coffeeBeansLevel);
        this.addIngredient(IngredientType.MILK, milkLevel);
    }

}
