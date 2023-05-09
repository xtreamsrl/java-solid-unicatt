package basic;

public class CoffeeMachine {

    private static final long COFFEE_COST = 50;

    int waterLevel;
    int coffeeBeansLevel;
    long userCredit; // cents


    public CoffeeMachine(int waterLevel, int coffeeBeansLevel) {
        this.waterLevel = waterLevel;
        this.coffeeBeansLevel = coffeeBeansLevel;
    }
    
    protected boolean creditIsSufficient() {
        return userCredit >= COFFEE_COST;
    }


    public void insertCoins(long amount) {
        this.userCredit += amount;
    }


    public long getUserCredit() {
        return this.userCredit;
    }

    public void makeCoffee() {
        if (creditIsSufficient()) {
            if (canMakeCoffee()) {
                this.waterLevel -= 50;
                this.coffeeBeansLevel -= 20;
                this.userCredit -= COFFEE_COST;
                System.out.println("Coffee is ready!");
            } else {
                System.out.println("Not enough ingredients for coffee!");
            }
        } else {
            System.out.println("Not enough credit for coffee! Add " + (COFFEE_COST - this.userCredit) + " cents");
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
