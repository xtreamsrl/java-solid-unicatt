public class CoffeeMachine {

    int waterLevel;
    int coffeeBeansLevel;

    public CoffeeMachine(int waterLevel, int coffeeBeansLevel) {
        this.waterLevel = waterLevel;
        this.coffeeBeansLevel = coffeeBeansLevel;
    }

    public void makeCoffee() {
            if (canMakeCoffee()) {
                this.waterLevel -= 50;
                this.coffeeBeansLevel -= 20;
                System.out.println("Coffee is ready!");
            } else {
                System.out.println("Not enough ingredients for coffee!");
            }
    }

    private boolean canMakeCoffee() {
        return waterLevel >= 50 && coffeeBeansLevel >= 20;
    }

    public void addWater(int water) {
        waterLevel += water;
    }

    public void addCoffeeBeans(int coffeeBeans) {
        coffeeBeansLevel += coffeeBeans;
    }

}
