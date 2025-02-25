package ducky;

public class Ui {

    //Method to print line separator
    public static void printBorder() {
        System.out.println("    ____________________________________________________________");
    }

    public static void printWelcomeMsg() {
        printBorder();
        System.out.println("    Hello! I'm Ducky!");
        System.out.println("    What can I do for you?");
        printBorder();
    }

    public static void printByeMsg() {
        Ui.printBorder();
        System.out.println("    Bye. Hope to see you again soon!");
        Ui.printBorder();
    }
}
