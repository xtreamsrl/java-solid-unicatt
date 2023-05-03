package solid;

public class CoffeeMachine {

    int waterLevel;
    int coffeeBeansLevel;
    long availableChange; // cents
    long userCredit; // cents


    public CoffeeMachine(int waterLevel, int coffeeBeansLevel, long availableChange) {
        this.waterLevel = waterLevel;
        this.coffeeBeansLevel = coffeeBeansLevel;
        this.availableChange = availableChange;
    }

    protected long getCoffeeCost() {
        return 50;
    }

    protected boolean creditIsSufficient() {
        return userCredit >= getCoffeeCost();
    }

    protected boolean canMakeDrink() {
        return waterLevel >= 50 && coffeeBeansLevel >= 20;
    }


    public void insertCoins(long amount) {
        this.setUserCredit(this.userCredit += amount);
        this.availableChange += amount;
    }

    public long getUserCredit() {
        return this.userCredit;
    }


    public void makeCoffee() {
        if (creditIsSufficient()) {
            if (canMakeDrink()) {
                this.waterLevel -= 50;
                this.coffeeBeansLevel -= 20;
                this.setUserCredit(this.userCredit - getCoffeeCost());
                this.availableChange -= getCoffeeCost();
                System.out.println("Coffee is ready!");
            } else {
                System.out.println("Not enough ingredients for coffee!");
            }
        } else {
            System.out.println("Not enough credit for coffee! Add " + (getCoffeeCost() - this.userCredit) + " cents");
        }

    }

    public void setUserCredit(long userCredit) {
        if(userCredit < 0) {
            throw new IllegalArgumentException("User credit must be greater than zero");
        }
        this.userCredit = userCredit;
    }

    public void addWater(int water) {
        waterLevel += water;
    }


    public void addCoffeeBeans(int coffeeBeans) {
        coffeeBeansLevel += coffeeBeans;
    }

}
