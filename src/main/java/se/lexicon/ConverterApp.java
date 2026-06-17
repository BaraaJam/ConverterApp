package se.lexicon;

import java.util.Scanner;

public class ConverterApp {
    public static final String[] CONVERTERS_MENU = {"Currency Converter", "Temperature Converter", "Length Converter"};
    private static final double SEK_TO_USD_RATE = 10.87;
    private static final double SEK_TO_EUR_RATE = 11.32;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean keepRunning = true;

        while(keepRunning){

            printMenu();
            int selectedOption = getValidOption(input);

            switch (selectedOption) {
                case 1 :
                    currencyConverter();
                    break;
                case 2 :
                    temperatureConverter();
                    break;
                case 3 :
                    lengthConverter();
                    break;
                case 4 :
                    System.out.print("Continue? (yes/no): ");
                    String doContinue = input.next();
                    if (doContinue.equalsIgnoreCase("yes")){
                        break;
                    } else {
                        System.out.print("Goodbye!");
                        keepRunning = false;
                    }
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

    private static void currencyConverter(){
        System.out.print("Currency Converter ");
    }

    private static void temperatureConverter(){
        System.out.print("Temperature Converter ");
    }

    private static void lengthConverter(){
        System.out.print("Length Converter ");
    }

}

