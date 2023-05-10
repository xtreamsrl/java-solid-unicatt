public class PaidCoffeeMachine extends CoffeeMachine {

    long userCredit; // cents

    public PaidCoffeeMachine(int waterLevel, int coffeeBeansLevel) {
        super(waterLevel, coffeeBeansLevel);
    }

    public long getCoffeeCost() {
        return 50;
    }

    public void insertCoins(long amount) {
        this.userCredit += amount;
    }


    public long getUserCredit() {
        return this.userCredit;
    }

    @Override
    public void makeCoffee() {
        if(userCredit < getCoffeeCost()) {
            System.out.println("Not enough credit for coffee! Add " + (getCoffeeCost() - this.userCredit) + " cents");
        } else {
            super.makeCoffee();
            this.userCredit -= getCoffeeCost();
        }
    }
}
