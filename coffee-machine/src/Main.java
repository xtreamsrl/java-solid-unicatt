import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        var drinkMachine = new DrinkMachineImpl();
//        drinkMachine.addIngredient(IngredientType.WATER, 500);
//        drinkMachine.addIngredient(IngredientType.COFFEE_BEAN, 100);
//        PaidDrinkMachine paidCoffeeMachine = new PaidDrinkMachine(drinkMachine);

        var drinkMachine = new DrinkMachineImpl();
        drinkMachine.addIngredient(IngredientType.WATER, 500);
        drinkMachine.addIngredient(IngredientType.COFFEE_BEAN, 100);
        drinkMachine.addIngredient(IngredientType.MILK, 200);

        Scanner scanner = new Scanner(System.in);
        CoffeeCommand input;

        while (true) {
            System.out.println("Enter command (coffee, cappuccino, add_water, add_beans, add_milk, insert_coin, exit): ");
            try {
                input = CoffeeCommand.valueOf(scanner.nextLine().toUpperCase());

                switch (input) {
                    case COFFEE -> {
                        try {
                            drinkMachine.makeDrink(new Coffee());
                            System.out.println("Coffee is ready!");
                        } catch (NotEnoughIngredientsException e) {
                            System.out.println("Not enough ingredients for coffee!");
                        } catch (NotEnoughCreditException e) {
                            System.out.println("Not enough credit for coffee! Add " + (e.getCost() - e.getCredit()) + " cents");
                        }
                    }
                    case CAPPUCCINO -> {
                        try {
                            drinkMachine.makeDrink(new Cappuccino());
                            System.out.println("Cappuccino is ready!");
                        } catch (NotEnoughIngredientsException e) {
                            System.out.println("Not enough ingredients for cappuccino!");
                        }
                    }
                    case ADD_WATER -> {
                        System.out.println("Enter the amount of water to add: ");
                        int water = scanner.nextInt();
                        scanner.nextLine();
                        drinkMachine.addIngredient(IngredientType.WATER, water);
                        System.out.println("Water added.");
                    }
                    case ADD_BEANS -> {
                        System.out.println("Enter the amount of coffee beans to add: ");
                        int beans = scanner.nextInt();
                        scanner.nextLine();
                        drinkMachine.addIngredient(IngredientType.COFFEE_BEAN, beans);
                        System.out.println("Coffee beans added.");
                    }
                    case ADD_MILK -> {
                        System.out.println("Enter the amount of milk to add: ");
                        int milk = scanner.nextInt();
                        scanner.nextLine();
                        drinkMachine.addIngredient(IngredientType.MILK, milk);
                        System.out.println("Milk added.");
                    }
//                    case INSERT_COIN -> {
//                        System.out.print("Enter a coin: ");
//                        long amount = scanner.nextLong();
//                        scanner.nextLine();
//                        drinkMachine.insertCoins(amount);
//                        System.out.println("Inserted " + amount + " cents");
//                        System.out.println("Your credit is now " + drinkMachine.getUserCredit() + " cents");
//                    }
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