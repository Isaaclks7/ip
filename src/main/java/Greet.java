import java.util.Scanner;

public class Greet {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm Ducky.");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");

        Scanner in = new Scanner(System.in);
        String line;
        String[] storedTexts = new String[100];
        int textCount = 0;

        while (true) {
            line = in.nextLine();
            if (line.equalsIgnoreCase("bye")) {
                break;
            }
            if (line.equalsIgnoreCase("list")) {
                for (int i = 0; i < textCount; i++) {
                    System.out.println((i + 1) + ". " + storedTexts[i]);
                }
            }
            storedTexts[textCount] = line;
            textCount++;

            System.out.println("    ____________________________________________________________");
            System.out.println("    added: " + line);
            System.out.println("    ____________________________________________________________");
        }

        System.out.println("    ____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }
}
