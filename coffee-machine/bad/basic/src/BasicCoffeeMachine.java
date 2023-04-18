package basic;

public class BasicCoffeeMachine implements CoffeeMachine {
    private static final long COFFEE_COST = 50;

    int waterLevel;
    int coffeeBeansLevel;
    long availableChange; // cents
    long userCredit; // cents


    public BasicCoffeeMachine(int waterLevel, int coffeeBeansLevel, long availableChange) {
        this.waterLevel = waterLevel;
        this.coffeeBeansLevel = coffeeBeansLevel;
        this.availableChange = availableChange;
    }

    protected boolean creditIsSufficient() {
        return userCredit >= COFFEE_COST;
    }

    protected boolean canMakeDrink() {
        return waterLevel >= 50 && coffeeBeansLevel >= 20;
    }


    @Override
    public void insertCoins(long amount) {
        this.userCredit += amount;
        this.availableChange += amount;
    }

    @Override
    public long getUserCredit() {
        return this.userCredit;
    }

    @Override
    public void makeCoffee() {
        if (creditIsSufficient()) {
            if (canMakeDrink()) {
                this.waterLevel -= 50;
                this.coffeeBeansLevel -= 20;
                this.userCredit -= COFFEE_COST;
                this.availableChange -= COFFEE_COST;
                System.out.println("Coffee is ready!");
            } else {
                System.out.println("Not enough ingredients for coffee!");
            }
        } else {
            System.out.println("Not enough credit for coffee! Add " + (COFFEE_COST - this.userCredit) + " cents");
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

}
