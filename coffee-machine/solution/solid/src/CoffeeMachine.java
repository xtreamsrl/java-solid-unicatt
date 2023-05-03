package solid;

public class CoffeeMachine {

    int waterLevel;
    int coffeeBeansLevel;


    public CoffeeMachine(int waterLevel, int coffeeBeansLevel) {
        this.waterLevel = waterLevel;
        this.coffeeBeansLevel = coffeeBeansLevel;
    }

    protected boolean canMakeDrink() {
        return waterLevel >= 50 && coffeeBeansLevel >= 20;
    }

    public void makeCoffee() {
        if (canMakeDrink()) {
            this.waterLevel -= 50;
            this.coffeeBeansLevel -= 20;
            System.out.println("Coffee is ready!");
        } else {
            System.out.println("Not enough ingredients for coffee!");
        }
    }


    public void addWater(int water) {
        waterLevel += water;
    }


    public void addCoffeeBeans(int coffeeBeans) {
        coffeeBeansLevel += coffeeBeans;
    }

}
