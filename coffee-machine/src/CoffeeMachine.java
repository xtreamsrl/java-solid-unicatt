
// Single Responsibility Principle violation: Multiple responsibilities
public class CoffeeMachine {
    int waterLevel;
    int coffeeBeansLevel;
    int milkLevel;
    long availableChange = 200; // cents
    long userCredit; // cents

    // Open/Closed Principle violation: Requires modifying the class to add new drink types
    public enum DrinkType {
        COFFEE(50), CAPPUCCINO(80);

        private final long price; // cents

        DrinkType(long price) {
            this.price = price;
        }

        public long getPrice(){
            return this.price;
        }
    }

    public CoffeeMachine(int waterLevel, int coffeeBeansLevel, int milkLevel) {
        this.waterLevel = waterLevel;
        this.coffeeBeansLevel = coffeeBeansLevel;
        this.milkLevel = milkLevel;
    }

    // Open/Closed Principle violation: Requires modifying the class to add new/remove drink types
    protected boolean canMakeDrink(DrinkType drinkType) {
        return switch (drinkType) {
            case COFFEE -> waterLevel >= 50 && coffeeBeansLevel >= 20 && userCredit >= drinkType.getPrice();
            case CAPPUCCINO -> waterLevel >= 100 && coffeeBeansLevel >= 20 && milkLevel >= 50 && userCredit >= drinkType.getPrice();
        };
    }

    public void insertCoins(long amount) {
        this.userCredit += amount;
        this.availableChange += amount;
    }

    public void orderDrink(DrinkType drinkType) {
        if(canMakeDrink(drinkType)) {
            this.userCredit -= drinkType.getPrice();
            this.availableChange -= this.userCredit;
        }
    }

}
