package premium;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            throw new RuntimeException("Run the program in coffee or cappuccino mode");
        }

        if(args[0].equals("coffee")) {
            handleCoffee();
        } else if (args[0].equals("cappuccino")) {
            handleCappuccino();
        }

        throw new RuntimeException("Run the program in 'coffee' or 'cappuccino' mode");
    }

    private static void handleCoffee() {
        CoffeeMachine coffeeMachine = new CoffeeMachine(500, 100,  200);

        Scanner scanner = new Scanner(System.in);
        CoffeeCommand input;

        while (true) {
            System.out.println("Enter command (coffee, add_water, add_beans, insert_coin, exit): ");
            try {
                input = CoffeeCommand.valueOf(scanner.nextLine().toUpperCase());

                switch (input) {
                    case COFFEE -> coffeeMachine.makeCoffee();

                    case ADD_WATER -> {
                        System.out.println("Enter the amount of water to add: ");
                        int water = scanner.nextInt();
                        scanner.nextLine();
                        coffeeMachine.addWater(water);
                        System.out.println("Water added.");
                    }
                    case ADD_BEANS -> {
                        System.out.println("Enter the amount of coffee beans to add: ");
                        int beans = scanner.nextInt();
                        scanner.nextLine();
                        coffeeMachine.addCoffeeBeans(beans);
                        System.out.println("Coffee beans added.");
                    }
                    case INSERT_COIN -> {
                        System.out.print("Enter a coin: ");
                        long amount = scanner.nextLong();
                        coffeeMachine.insertCoins(amount);
                        scanner.nextLine();
                        System.out.println("Inserted " + amount + " cents");
                        System.out.println("Your credit is now " + coffeeMachine.getUserCredit() + " cents");
                    }
                    case EXIT -> {
                        scanner.close();
                        System.exit(0);
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid command.");
            }
        }
    }

    private static void handleCappuccino() {
        CappuccinoMachine coffeeMachine = new CappuccinoMachine(500, 100,  200);

        Scanner scanner = new Scanner(System.in);
        CoffeeCommand input;

        while (true) {
            System.out.println("Enter command (coffee, cappuccino, add_water, add_beans, add_milk, exit): ");
            try {
                input = CoffeeCommand.valueOf(scanner.nextLine().toUpperCase());

                switch (input) {
                    case COFFEE -> coffeeMachine.makeCoffee();
                    case CAPPUCCINO -> coffeeMachine.makeCappuccino();
                    case ADD_WATER -> {
                        System.out.println("Enter the amount of water to add: ");
                        int water = scanner.nextInt();
                        scanner.nextLine();
                        coffeeMachine.addWater(water);
                        System.out.println("Water added.");
                    }
                    case ADD_BEANS -> {
                        System.out.println("Enter the amount of coffee beans to add: ");
                        int beans = scanner.nextInt();
                        scanner.nextLine();
                        coffeeMachine.addCoffeeBeans(beans);
                        System.out.println("Coffee beans added.");
                    }
                    case ADD_MILK -> {
                        System.out.println("Enter the amount of milk to add: ");
                        int milk = scanner.nextInt();
                        scanner.nextLine();
                        coffeeMachine.addMilk(milk);
                        System.out.println("Milk added.");
                    }
                    case EXIT -> {
                        scanner.close();
                        System.exit(0);
                    }
                }
            } catch (Exception e) {
                System.out.println("An error occurred.");
            }

        }
    }
}