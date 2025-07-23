import java.util.Scanner;
import java.util.InputMismatchException;

public class Utilities {
    static Scanner scanner = new Scanner(System.in);
    public static void outputLineDelay(String str, double delayS) {
        try {
            System.out.println(str);
            Thread.sleep((long)(delayS * 1000));
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void displayFormat(char symbol, int length, double delayS) {
        try {
            for (int i = 0; i < length; ++i) {
                System.out.print(symbol);
            } System.out.println();
            Thread.sleep((long)(delayS * 1000));
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void errorMessage(String message) {
        System.out.printf("ERROR: %s", message);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressEnterToContinue() {
        System.out.print("Press [Enter] to continue...");
        scanner.nextLine();
    }

    public static void dialogue(String speaker, String message, double characterDelayS) {
        try {
            System.out.printf("[%s]: ", speaker);
            Thread.sleep(1000);

            for (int i = 0; i < message.length(); ++i) {
                System.out.print(message.charAt(i));
                Thread.sleep((long)(characterDelayS * 1000));
            } System.out.println();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int response(String[] choices) {
        int choiceCounter = 1;
        int userChoice = 1;

        for (String choice : choices) {
            System.out.printf("[%d] %s\n", choiceCounter, choice);

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            } choiceCounter++;
        }

        System.out.print(">> ");
        try {
            userChoice = scanner.nextInt();
            scanner.nextLine();
        } catch(InputMismatchException e) {
            scanner.nextLine();
        } Utilities.clearScreen();

        return userChoice;
    }

    public static void handleChoice(String speaker, int choice, String[] responses) {
        if (choice >= 0 && choice < responses.length) {
            System.out.printf("[%s]: %s\n", speaker, responses[choice]);
        } else {
            System.out.printf("[%s]: ... (no response)\n", speaker);
        }   
    }

    public static void addInventory(String itemName, int itemQuantity, String itemDescription) {

    }
}