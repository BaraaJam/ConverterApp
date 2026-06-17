package se.lexicon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.ZoneId;

public class ConverterApp {
    public static final String[] CONVERTERS_MENU = {"Currency Converter", "Temperature Converter", "Length Converter"};
    private static final double SEK_TO_USD_RATE = 10.87;
    private static final double SEK_TO_EUR_RATE = 11.32;
    private static final double CELSIUS_TO_FAHRENHEIT = 9.0 / 5.0;
    private static final double FAHRENHEIT_TO_CELSIUS = 5.0 / 9.0;
    private static final double CM_TO_M = 100.0;
    private static final double M_TO_KM = 1000.0;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> history = new ArrayList<>();

        while(true) {

            printMenu();
            int selectedOption = getValidOption(input);

            if (selectedOption == (CONVERTERS_MENU.length + 1)) {
                printHistory(history);
                System.out.print("Goodbye!");
                break;
            }

            switch (selectedOption) {
                case 1:
                    currencyConverter(input, history);
                    break;
                case 2:
                    temperatureConverter(input, history);
                    break;
                case 3:
                    lengthConverter(input, history);
                    break;
            }

            System.out.print("\nContinue? (yes/no): ");
            String doContinue = input.next();
            if (doContinue.equalsIgnoreCase("no")) {
                printHistory(history);
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
                System.out.print("Choose an option: ");
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

    private static void currencyConverter(Scanner input, ArrayList<String> history){
        System.out.println("--- Currency Converter ---");
        System.out.println("Converter:");
        System.out.println("  1. SEK to USD");
        System.out.println("  2. SEK to EUR");

        while (true) {
            try {
                System.out.print("Your choice: ");
                int currencyChoice = input.nextInt();

                if (currencyChoice == 1) {
                    System.out.print("Enter amount in SEK: ");
                    double currencyAmount = input.nextDouble();
                    if (currencyAmount >= 0) {
                        double getConvertResult = currencyAmount / SEK_TO_USD_RATE;
                        String resultFormat = String.format("%.2f SEK = %.2f USD", currencyAmount, getConvertResult);

                        System.out.println("Result: " + resultFormat);
                        timeStamp();

                        history.add(resultFormat);
                        break;

                    } else {
                        System.out.print("Invalid amount,please try again!\n");
                    }

                } else if (currencyChoice == 2) {
                    System.out.print("Enter amount in SEK: ");
                    double currencyAmount = input.nextDouble();
                    if (currencyAmount >= 0) {
                        double getConvertResult = currencyAmount / SEK_TO_EUR_RATE;
                        String resultFormat = String.format("%.2f SEK = %.2f EUR", currencyAmount, getConvertResult);
                        System.out.println("Result: " + resultFormat);
                        timeStamp();

                        history.add(resultFormat);
                        break;

                    } else {
                        System.out.print("Invalid amount,please try again!\n");
                    }

                } else {
                    System.out.println("Invalid option.");
                }

            } catch (java.util.InputMismatchException e){
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        }
    }

    private static void temperatureConverter(Scanner input, ArrayList<String> history){
        System.out.println("--- Temperature Converter ---");
        System.out.println("Converter:");
        System.out.println("  1. Celsius to Fahrenheit");
        System.out.println("  2. Fahrenheit to Celsius");

        while (true) {
            try {
                System.out.print("Your choice: ");
                int tempChoice = input.nextInt();

                if (tempChoice == 1) {
                    System.out.print("Enter temperature in Celsius: ");
                    double temperature = input.nextDouble();
                    if (temperature >= -273.15) {
                        double getConvertResult = temperature * CELSIUS_TO_FAHRENHEIT + 32;
                        String resultFormat = String.format("%.2f C = %.2f F", temperature, getConvertResult);

                        System.out.println("Result: " + resultFormat);
                        timeStamp();

                        history.add(resultFormat);
                        break;

                    } else {
                        System.out.println("Invalid value. Temperature cannot be below absolute zero " + temperature);
                    }

                } else if (tempChoice == 2) {
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double temperature = input.nextDouble();
                    if (temperature >= -459.67) {
                        double getConvertResult = (temperature - 32) * FAHRENHEIT_TO_CELSIUS;
                        String resultFormat = String.format("%.2f F = %.2f C", temperature, getConvertResult);

                        System.out.println("Result: " + resultFormat);
                        timeStamp();

                        history.add(resultFormat);
                        break;

                    } else {
                        System.out.println("Invalid value. Temperature cannot be below absolute zero " + temperature);
                    }

                } else {
                    System.out.println("Invalid option.");
                }

            } catch (java.util.InputMismatchException e){
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        }

    }

    private static void lengthConverter(Scanner input, ArrayList<String> history){
        System.out.println("--- Length Converter ---");
        System.out.println("Converter:");
        System.out.println("  1. Centimeters to Meters");
        System.out.println("  2. Meters  to Kilometers");

        while (true) {
            try {
                System.out.print("Your choice: ");
                int lengthChoice = input.nextInt();

                if (lengthChoice == 1) {
                    System.out.print("Enter length in centimeters : ");
                    double length = input.nextDouble();
                    if (length >= 0) {
                        double getConvertResult = length / CM_TO_M;
                        String resultFormat = String.format("%.2f CM = %.2f M", length, getConvertResult);

                        System.out.println("Result: " + resultFormat);
                        timeStamp();

                        history.add(resultFormat);
                        break;

                    } else {
                        System.out.println("Invalid amount. Length cannot be negative.");
                    }

                } else if (lengthChoice == 2) {
                    System.out.print("Enter length in meters : ");
                    double length = input.nextDouble();
                    if (length >= 0) {
                        double getConvertResult = length / M_TO_KM;
                        String resultFormat = String.format("%.2f M = %.2f KM", length, getConvertResult);

                        System.out.println("Result: " + resultFormat);
                        timeStamp();

                        history.add(resultFormat);
                        break;
                    } else {
                        System.out.println("Invalid amount. Length cannot be negative.");
                    }
                } else {
                    System.out.println("Invalid option.");
                }

            } catch (java.util.InputMismatchException e){
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        }
    }

    private static void timeStamp() {
        ZoneId userTime = ZoneId.systemDefault();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("eeee, yyyy-MM-dd HH:mm");
        String formattedTime = currentDateTime.format(formatter);
        System.out.println("Converted at: " + formattedTime + " " + userTime);

    }

    private static void printHistory(ArrayList<String> history) {
        System.out.print("\n===== Conversion History =====\n");
        for (int i = 0; i < history.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), history.get(i));
        }
        System.out.print("==============================\n");
    }

}