// Liskov Substitution Principle violation: Subclasses can't be used as a direct replacement for the parent class
public class BasicCoffeeMachine extends CoffeeMachine implements CoffeeActions {
    BasicCoffeeMachine(int waterLevel, int coffeeBeansLevel, int milkLevel) {
        super(waterLevel, coffeeBeansLevel, milkLevel);
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
        throw new UnsupportedOperationException("BasicCoffeeMachine can't make cappuccino.");
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
