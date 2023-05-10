public class CappuccinoMachine extends CoffeeMachine {

    private int milkLevel;

    public CappuccinoMachine(int waterLevel, int coffeeBeansLevel, int milkLevel) {
        super(waterLevel, coffeeBeansLevel);
        this.milkLevel = milkLevel;
    }

    void makeCappuccino() {
        if(canMakeCappuccino()) {
            this.waterLevel -= 100;
            this.coffeeBeansLevel -= 20;
            this.milkLevel -= 50;
            System.out.println("Your cappuccino is ready.");
        } else {
            System.out.println("Not enough ingredients.");
        }
    }

    private boolean canMakeCappuccino() {
        return this.waterLevel >= 100 && this.coffeeBeansLevel >= 20 && this.milkLevel >= 50;
    }

    public void addMilk(int milk) {
        this.milkLevel += milk;
    }
}
