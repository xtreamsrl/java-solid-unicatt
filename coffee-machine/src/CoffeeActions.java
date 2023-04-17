// Interface Segregation Principle violation: Unrelated methods combined
interface CoffeeActions {
    void makeCoffee();

    void makeCappuccino();

    void addWater(int water);

    void addCoffeeBeans(int coffeeBeans);

    void addMilk(int milk);
}