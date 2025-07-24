import java.util.Scanner;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Interface {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        Utilities.outputLineDelay("~        [ FizzUp! ]         ~", 0.1);
        Utilities.displayFormat('#', 30, 0.1);
        Utilities.outputLineDelay("[1] Start Fizzin'", 0.1);
        Utilities.outputLineDelay("[2] Statistics", 0.1);
        Utilities.outputLineDelay("[3] Achievements", 0.1);
        Utilities.outputLineDelay("[4] Exit", 0.1);
        Utilities.displayFormat('#', 30, 0.1);
    }

    public static void displayInventoryMenu() {
        System.out.println("[ INVENTORY ]");
        Utilities.pressEnterToContinue();
    }

    public static void displayUpgradesMenu() {
        System.out.println("[ UPGRADES ]");
        
        @SuppressWarnings("unchecked")
        Map<String, Integer> upgrades = Data.getUpgrades();

        for (Map.Entry<String, Integer> upgrade : upgrades.entrySet()) {
            String name = upgrade.getKey();
            int value = upgrade.getValue();
            
            int spaceLength = 13 - (name.length() + 4);
            String space = " ".repeat(Math.max(0, spaceLength));

            System.out.printf("%s[ %s ] %d\n", space, name, value);
        }

        Utilities.pressEnterToContinue();
    }

    public static void displayCollectionMenu() {
        System.out.println("[ COLLECTION ]");
        Utilities.pressEnterToContinue();
    }
    
    public static void displaySellItemsMenu() {
        System.out.println("[ SELL ITEMS ]");
        Utilities.pressEnterToContinue();
    }

    public static void displayGameHeader() {
        Utilities.clearScreen();

        Utilities.displayFormat('#', 38, 0.1);
        System.out.printf("Lvl. %d [ Mr. Fizz the Mix'a Machine ]\n", Data.getIntData("level"));
        System.out.printf("%d PHP\n", Data.getIntData("money"));
        
        Utilities.displayFormat('#', 38, 0.1);
    }

    public static void displayGameArea() {

    }

    public static void displayGameNavigation() {
        char key = '\0';

        Utilities.displayFormat('#', 38, 0.1);
        System.out.println("[Z] Inventory    [X] Upgrades");
        System.out.println("[C] Collection   [V] Sell Items");
        Utilities.displayFormat('#', 38, 0.1);

        key = scanner.next().charAt(0);

        Utilities.clearScreen();

        switch(key) {
            case 'z':
                displayInventoryMenu();
                break;
            case 'x':
                displayUpgradesMenu();
                break;
            case 'c':
                displayCollectionMenu();
                break;
            case 'v':
                displaySellItemsMenu();
                break;
            default:
                
                break;
        }
    }

    public static void displayGameInterface() {
        while (true) {
            displayGameHeader();
            displayGameArea();
            displayGameNavigation();
        }
    }

    public static void startIntroduction() {
        int choice = 1;

/*         // Dialogue #1
        Utilities.dialogue("???", "Hey there...", 0.1);
        choice = Utilities.response(new String[] {"Hello!", "Who are you?"});
        Utilities.handleChoice("???", choice, new String[] {"Now, that's the spirit!", "Uh, nevermind me..."});
        
        // Dialogue #2
        Utilities.dialogue("???", "The thing is, I really need your help right now.", 0.1);
        choice = Utilities.response(new String[] {"Help with what?", "No thanks."});
        Utilities.handleChoice("???", choice, new String[] {"I...", "Come on now, don't be like that..."});
        
        // Dialogue #3
        Utilities.dialogue("???", "I'm broke. I literally have 0 pesos in my bank account...", 0.1);
        choice = Utilities.response(new String[] {"What does that have to do with me?", "Well, you probably spent all of it gambling."});
        Utilities.handleChoice("???", choice, new String[] {"Please! You need to save me from those cruel mobs!", "Well yes..., but that's not the point!"});
        
        // Dialogue #4
        Utilities.dialogue("???", "I need to repay my million pesos debt, or else...", 0.1);
        choice = Utilities.response(new String[] {"...or else?", "Goodluck."});
        Utilities.handleChoice("???", choice, new String[] {"They will take away my Honda Civic Type R!!!", "Please, I beg you!"});
        
        // Dialogue #5
        Utilities.dialogue("???", "You can't leave a friend hanging...", 0.1);
        choice = Utilities.response(new String[] {"Who even are you?", "I don't even know you..."});
        Utilities.handleChoice("Rich", choice, new String[] {"The name's Rich...", "I'm Rich..."});

        // Dialogue #6
        Utilities.dialogue("Rich", "Rich McGrover!", 0.1);
        choice = Utilities.response(new String[] {"Now ain't that ironic...", "...seriously?"});
        Utilities.handleChoice("Rich", choice, new String[] {"Whatever, laugh all you want!", "I am being serious!..."});

        // Dialogue #7
        Utilities.dialogue("Rich", "Now listen, I've thought of a very FULL-PROOF idea to get us out of this hellhole!", 0.1);
        choice = Utilities.response(new String[] {"...which is?", "Oh, now it's WE..."});
        Utilities.handleChoice("Rich", choice, new String[] {"...", "Just, bear with me..."});
        
        // Dialogue #8
        Utilities.dialogue("Rich", "Here, take this...", 0.1);
        Data.addPermanentInventory("Mr. Fizz the Mix'a Machine", "Hi there! I'm Mr. Fizz, the Mix'a Machine!");
        choice = Utilities.response(new String[] {"What is this?", "Mix'a... Machine?"});
        
        Utilities.dialogue("Rich", "I bought it from an auction 20 years ago, but I never used it. It cost me hundreds of millions to get that, kid.", 0.1);
        choice = Utilities.response(new String[] {"So you bought it for what, exactly?", "..."});
        Utilities.handleChoice("Rich", choice, new String[] {"I bought it because I can!", "Anyways..."});


        Utilities.dialogue("Rich", "I have 100 days to settle my debt... Goodluck kid! I'll be hiding, somewhere...", 0.1);
        choice = Utilities.response(new String[] {"Let's start fizzin'!", "You can count on me."}); */

        displayGameInterface();
    }

    public static void displayStatisticsMenu() {
        Utilities.outputLineDelay("~       [ Statistics ]       ~", 0.1);
        Utilities.displayFormat('#', 30, 0.1);
        Utilities.pressEnterToContinue();
    }

    public static void displayAchievementsMenu() {
        Utilities.outputLineDelay("~     [ Achievements ]       ~", 0.1);
        Utilities.displayFormat('#', 30, 0.1);
        Utilities.pressEnterToContinue();
    }
}