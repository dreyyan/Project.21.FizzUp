public class Interface {

    public static void displayMainMenu() {
        Utilities.outputLineDelay("~        [ FizzUp! ]         ~", 0.1);
        Utilities.displayFormat('#', 30, 0.1);
        Utilities.outputLineDelay("[1] Start Fizzin'", 0.1);
        Utilities.outputLineDelay("[2] Statistics", 0.1);
        Utilities.outputLineDelay("[3] Achievements", 0.1);
        Utilities.outputLineDelay("[4] Exit", 0.1);
        Utilities.displayFormat('#', 30, 0.1);
    }

    public static void displayGameInterface() {
        return;
    }

    public static void startIntroduction() {
        int choice = 1;

        // Dialogue #1
        Utilities.dialogue("Narrator", "Hi there, ", 0.1);
        choice = Utilities.response(new String[] {"Hello there!", "Who are you?"});
        Utilities.handleChoice("Narrator", choice, new String[] {"Now, that's the spirit!", "Uh, nevermind me..."});
        
        // Dialogue #2
        Utilities.dialogue("Narrator", "Hi...", 0.1);
        choice = Utilities.response(new String[] {"Hello there!", "Who are you?"});
        Utilities.handleChoice("Narrator", choice, new String[] {"Now, that's the spirit!", "Uh, nevermind me..."});
        
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