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
        Utilities.handleChoice("", choice, new String[] {"Whatever, laugh all you want!", "Come on now..."});

        // Dialogue #7
        Utilities.dialogue("Rich", "Now listen, I've thought of a very FULL-PROOF idea to get us out of this hellhole!", 0.1);
        choice = Utilities.response(new String[] {"...which is?", "Oh, now it's WE..."});
        Utilities.handleChoice("Rich", choice, new String[] {"...", "Just, bear with me..."});
        
        // Dialogue #3
        Utilities.dialogue("Rich", "Here, take this...", 0.1);




        choice = Utilities.response(new String[] {"", ""});
        Utilities.handleChoice("", choice, new String[] {"", ""});
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