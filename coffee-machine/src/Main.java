import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaidCoffeeMachine coffeeMachine = new PaidCoffeeMachine(500, 100);

        Scanner scanner = new Scanner(System.in);
        CoffeeCommand input;

        while (true) {
            System.out.println("Enter command (coffee, cappuccino, add_water, add_beans, add_milk, insert_coin, exit): ");
            try {
                input = CoffeeCommand.valueOf(scanner.nextLine().toUpperCase());

                switch (input) {
                    case COFFEE -> coffeeMachine.makeCoffee();
//                    case CAPPUCCINO -> cappuccinoMachine.makeCappuccino();
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
//                    case ADD_MILK -> {
//                        System.out.println("Enter the amount of milk to add: ");
//                        int milk = scanner.nextInt();
//                        scanner.nextLine();
//                        cappuccinoMachine.addMilk(milk);
//                        System.out.println("Milk added.");
//                    }
                    case INSERT_COIN -> {
                        System.out.print("Enter a coin: ");
                        long amount = scanner.nextLong();
                        scanner.nextLine();
                        coffeeMachine.insertCoins(amount);
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
}