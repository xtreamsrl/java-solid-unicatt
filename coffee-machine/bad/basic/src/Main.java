package basic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BasicCoffeeMachine basicCoffeeMachine = new BasicCoffeeMachine(500, 100, 200, 200);

        Scanner scanner = new Scanner(System.in);
        CoffeeCommand input;

        while (true) {
            System.out.println("Enter command (coffee, cappuccino, add_water, add_beans, add_milk, insert_coin, exit): ");
            try {

                input = CoffeeCommand.valueOf(scanner.nextLine().toUpperCase());

                switch (input) {
                    case COFFEE -> basicCoffeeMachine.orderDrink(BasicCoffeeMachine.DrinkType.COFFEE);
                    case CAPPUCCINO -> {
                        try {
                            basicCoffeeMachine.orderDrink(BasicCoffeeMachine.DrinkType.CAPPUCCINO);
                        } catch (UnsupportedOperationException e) {
                            System.out.println("bad.basic.CoffeeMachine can't make cappuccino.");
                        }
                    }
                    case ADD_WATER -> {
                        System.out.println("Enter the amount of water to add: ");
                        int water = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        basicCoffeeMachine.addWater(water);
                        System.out.println("Water added.");
                    }
                    case ADD_BEANS -> {
                        System.out.println("Enter the amount of coffee beans to add: ");
                        int beans = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        basicCoffeeMachine.addCoffeeBeans(beans);
                        System.out.println("Coffee beans added.");
                    }
                    case ADD_MILK -> {
                        System.out.println("Enter the amount of milk to add: ");
                        int milk = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        basicCoffeeMachine.addMilk(milk);
                        System.out.println("Milk added.");
                    }
                    case INSERT_COIN -> {
                        System.out.print("Enter a coin: ");
                        long amount = scanner.nextLong();
                        basicCoffeeMachine.insertCoins(amount);
                        scanner.nextLine(); // Consume newline character
                        System.out.println("Inserted " + amount + " cents");
                        System.out.println("Your credit is now " + basicCoffeeMachine.userCredit + " cents");
                    }
                    case EXIT -> {
                        scanner.close();
                        System.exit(0);
                    }
                }
            } catch (Exception e) {
                // scanner.close();
                System.out.println("Invalid command.");
            }

        }

    }
}