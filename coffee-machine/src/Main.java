import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(500, 100, 200);
        BasicCoffeeMachine basicCoffeeMachine = new BasicCoffeeMachine();

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Enter command (coffee, cappuccino, add_water, add_beans, add_milk, exit): ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("coffee")) {
                basicCoffeeMachine.makeCoffee();
            } else if (input.equalsIgnoreCase("cappuccino")) {
                try {
                    basicCoffeeMachine.makeCappuccino();
                } catch (UnsupportedOperationException e) {
                    System.out.println("BasicCoffeeMachine can't make cappuccino.");
                }
            } else if (input.equalsIgnoreCase("add_water")) {
                System.out.println("Enter the amount of water to add: ");
                int water = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                basicCoffeeMachine.addWater(water);
                System.out.println("Water added.");
            } else if (input.equalsIgnoreCase("add_beans")) {
                System.out.println("Enter the amount of coffee beans to add: ");
                int beans = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                basicCoffeeMachine.addCoffeeBeans(beans);
                System.out.println("Coffee beans added.");
            } else if (input.equalsIgnoreCase("add_milk")) {
                System.out.println("Enter the amount of milk to add: ");
                int milk = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                basicCoffeeMachine.addMilk(milk);
                System.out.println("Milk added.");
            } else if (input.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }
}