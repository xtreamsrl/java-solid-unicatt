package solid;

public class PaidCoffeeMachine {
    private final CoffeeMachine coffeeMachine;

    long availableChange; // cents
    long userCredit; // cents

    public PaidCoffeeMachine(CoffeeMachine coffeeMachine, long availableChange) {
        this.coffeeMachine = coffeeMachine;
        this.availableChange = availableChange;
    }

    protected long getCoffeeCost() {
        return 50;
    }

    protected boolean creditIsSufficient() {
        return userCredit >= getCoffeeCost();
    }

    public long getUserCredit() {
        return this.userCredit;
    }


    public void insertCoins(long amount) {
        this.setUserCredit(this.userCredit += amount);
        this.availableChange += amount;
    }

    public void setUserCredit(long userCredit) {
        if(userCredit < 0) {
            throw new IllegalArgumentException("User credit must be greater than zero");
        }
        this.userCredit = userCredit;
    }

    public void makeCoffee() {
        if(creditIsSufficient() && coffeeMachine.canMakeDrink()) {
            this.setUserCredit(this.userCredit - getCoffeeCost());
            this.availableChange -= getCoffeeCost();
            coffeeMachine.makeCoffee();
        } else {
            System.out.println("Not enough credit for coffee! Add " + (getCoffeeCost() - this.userCredit) + " cents");
        }
    }

    public void addWater(int water) {
       coffeeMachine.addWater(water);
    }

    public void addCoffeeBeans(int coffeeBeans) {
        coffeeMachine.addCoffeeBeans(coffeeBeans);
    }

}
