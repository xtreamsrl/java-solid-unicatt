package solid;


class CappuccinoMachine extends CoffeeMachine {
    int milkLevel;
    CappuccinoMachine(int waterLevel, int coffeeBeansLevel, int milkLevel) {
        super(waterLevel, coffeeBeansLevel, 0);
        this.milkLevel = milkLevel;
    }

    @Override
    protected long getCoffeeCost() {
        return 0;
    }

    @Override
    protected boolean canMakeDrink() {
        return waterLevel >= 100 && coffeeBeansLevel >= 20 && milkLevel >= 50;
    }

    @Override
    public void insertCoins(long amount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getUserCredit() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected boolean creditIsSufficient() {
        return true;
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
