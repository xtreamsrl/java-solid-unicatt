package bad.premium;

import bad.basic.CoffeeActions;
import bad.basic.CoffeeMachine;

class CappuccinoMachine extends CoffeeMachine implements CoffeeActions {
    CappuccinoMachine(int waterLevel, int coffeeBeansLevel, int milkLevel, long availableChange) {
        super(waterLevel, coffeeBeansLevel, milkLevel, availableChange);
    }

    @Override
    public void makeCoffee() {
        if (canMakeDrink(DrinkType.COFFEE)) {
            waterLevel -= 50;
            coffeeBeansLevel -= 20;
            System.out.println("Coffee is ready!");
        } else {
            System.out.println("Not enough ingredients for coffee!");
        }
    }

    @Override
    public void makeCappuccino() {
        if (canMakeDrink(DrinkType.CAPPUCCINO)) {
            waterLevel -= 100;
            coffeeBeansLevel -= 20;
            milkLevel -= 50;
            System.out.println("Cappuccino is ready!");
        } else {
            System.out.println("Not enough ingredients for cappuccino!");
        }
    }

    @Override
    public void addWater(int water) {
        waterLevel += water;
    }

    @Override
    public void addCoffeeBeans(int coffeeBeans) {
        coffeeBeansLevel += coffeeBeans;
    }

    @Override
    public void addMilk(int milk) {
        milkLevel += milk;
    }
}
