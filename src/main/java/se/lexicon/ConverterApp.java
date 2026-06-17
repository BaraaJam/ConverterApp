package se.lexicon;

import java.util.Scanner;

public class ConverterApp {
    public static final String[] CONVERTERS_MENU = {"Currency Converter", "Temperature Converter", "Length Converter"};
    private static final double SEK_TO_USD_RATE = 10.87;
    private static final double SEK_TO_EUR_RATE = 11.32;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true) {

            printMenu();
            int selectedOption = getValidOption(input);

            if (selectedOption == (CONVERTERS_MENU.length + 1)) {
                System.out.print("Goodbye!");
                break;
            }

            switch (selectedOption) {
                case 1:
                    currencyConverter(input);
                    break;
                case 2:
                    temperatureConverter();
                    break;
                case 3:
                    lengthConverter();
                    break;
            }

            System.out.print("\nContinue? (yes/no): ");
            String doContinue = input.next();
            if (doContinue.equalsIgnoreCase("no")) {
                System.out.print("Goodbye!");
                break;
            }
        }
        input.close();
    }

    private static void printMenu() {
        System.out.println("==============================");
        System.out.println("    LEXICON CONVERTER APP     ");
        System.out.println("==============================");

        for (int i=0; i < CONVERTERS_MENU.length; i++) {
            System.out.printf("%d. %-15s\n", (i + 1), CONVERTERS_MENU[i]);

        }
        System.out.println((CONVERTERS_MENU.length + 1) + ". EXIT");
        System.out.println("==============================");
    }

    private static int getValidOption(Scanner input){
        while (true){
            try {
                System.out.print("Choose an option ");
                int selectedOption = input.nextInt();
                input.nextLine();

                if (selectedOption >= 1 && selectedOption <= (CONVERTERS_MENU.length + 1)) {
                    return selectedOption;
                } else {
                    System.out.println("Error: Invalid choice. Please Enter item number(1-" + (CONVERTERS_MENU.length + 1) + ").");
                }
            } catch (java.util.InputMismatchException e){
                System.out.println("Error: That is not a valid number. Try again!");
                input.nextLine();
            }
        }
    }

    private static void currencyConverter(Scanner input){
        System.out.println("--- Currency Converter ---");
        System.out.println("Converter:");
        System.out.println("  1. SEK to USD");
        System.out.println("  2. SEK to EUR");

        while (true) {
            System.out.print("Your choice: ");
            int currencyChoice = input.nextInt();

            if (currencyChoice == 1) {
                System.out.print("Enter amount in SEK: ");
                double currencyAmount = input.nextDouble();
                double getConvertResult = currencyAmount / SEK_TO_USD_RATE;
                System.out.printf("Result: %.2f SEK = %.2f USD\n", currencyAmount, getConvertResult);
                break;

            } else if (currencyChoice == 2) {
                System.out.print("Enter amount in SEK: ");
                double currencyAmount = input.nextDouble();
                double getConvertResult = currencyAmount / SEK_TO_EUR_RATE;
                System.out.printf("Result: %.2f SEK = %.2f EUR\n", currencyAmount, getConvertResult);

                break;

            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private static void temperatureConverter(){
        System.out.print("Temperature Converter ");
    }

    private static void lengthConverter(){
        System.out.print("Length Converter ");
    }

}

