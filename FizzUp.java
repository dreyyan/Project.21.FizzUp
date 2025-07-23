import java.util.Scanner;
import java.util.InputMismatchException;

public class FizzUp {
    static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        String strInput = scanner.nextLine();
        return strInput;
    }

    public static int getIntInput(String prompt) {
        int intInput = -1;

        System.out.print(prompt);
        try {
            intInput = scanner.nextInt();
            scanner.nextLine();
        } catch(InputMismatchException e) {
            scanner.nextLine();
            Utilities.errorMessage("Invalid input, please enter a valid number.");
        }

        return intInput;
    }

    public static float getFloatInput(String prompt) {
        float floatInput = -1.00f;

        System.out.print(prompt);
        try {
            floatInput = scanner.nextFloat();
            scanner.nextLine();
        } catch(InputMismatchException e) {
            scanner.nextLine();
            Utilities.errorMessage("Invalid input, please enter a valid floating number.");
        }

        return floatInput;
    }

    public static void main(String[] args) {
        while (true) {
            Utilities.clearScreen();
            
            Interface.displayMainMenu();
            int userChoice = getIntInput(">> ");

            Utilities.clearScreen();
            switch(userChoice) {
                case 1:
                    Interface.startIntroduction();
                    break;
                case 2:
                    Interface.displayStatisticsMenu();
                    break;
                case 3:
                    Interface.displayAchievementsMenu();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}