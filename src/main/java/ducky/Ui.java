package ducky;

/**
 * This Ui class manages interactive messages with the user.
 */
public class Ui {

    //Prints line separator
    public static void printBorder() {
        System.out.println("    ____________________________________________________________");
    }

    //Prints a welcome message to indicate start of program
    public static void printWelcomeMsg() {
        printBorder();
        System.out.println("    Hello! I'm Ducky!");
        System.out.println("    What can I do for you?");
        printBorder();
    }

    //Prints a goodbye message to indicate end of program
    public static void printByeMsg() {
        Ui.printBorder();
        System.out.println("    Bye. Hope to see you again soon!");
        Ui.printBorder();
    }
}
