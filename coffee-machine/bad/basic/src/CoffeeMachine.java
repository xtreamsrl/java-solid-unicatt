package basic;

// Interface Segregation Principle violation: Unrelated methods combined
interface CoffeeMachine {

    void makeCoffee();

    void addWater(int water);

    void addCoffeeBeans(int coffeeBeans);

    void insertCoins(long amount);
}