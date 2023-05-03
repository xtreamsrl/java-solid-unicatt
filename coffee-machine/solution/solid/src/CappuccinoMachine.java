package solid;


class CappuccinoMachine extends CoffeeMachine {
    int milkLevel;
    CappuccinoMachine(int waterLevel, int coffeeBeansLevel, int milkLevel) {
        super(waterLevel, coffeeBeansLevel);
        this.milkLevel = milkLevel;
    }

    @Override
    protected boolean canMakeDrink() {
        return waterLevel >= 100 && coffeeBeansLevel >= 20 && milkLevel >= 50;
    }

    public void addMilk(int milk) {
        this.milkLevel += milk;
    }

    public void makeCappuccino() {
        if (canMakeDrink()) {
            waterLevel -= 100;
            coffeeBeansLevel -= 20;
            milkLevel -= 50;
            System.out.println("Cappuccino is ready!");
        } else {
            System.out.println("Not enough ingredients for cappuccino!");
        }
    }

}
