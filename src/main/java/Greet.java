import java.util.Scanner;

public class Greet {
    public static void main(String[] args) {
        printBorder();
        System.out.println("    Hello! I'm Ducky.");
        System.out.println("    What can I do for you?");
        printBorder();

        Scanner in = new Scanner(System.in);
        String line;
        Task[] storedTasks = new Task[100];
        int taskCount = 0;

        while (true) {
            line = in.nextLine();

            if (line.isEmpty()) {
                continue;
            }

            if (line.equalsIgnoreCase("bye")) {
                break;
            }

            if (line.equalsIgnoreCase("list")) {
                printBorder();
                System.out.println("    Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println("    " + (i + 1) + "." + "[" + storedTasks[i].getStatusIcon()  + "]" + storedTasks[i].description);
                }
                printBorder();
                continue;
            }

            if (line.toLowerCase().startsWith("mark ")) {
                int taskIndex = Integer.parseInt(line.substring(4).trim());
                storedTasks[taskIndex - 1].setDone(true);
                printBorder();
                System.out.println("    Nice! I've marked this task as done:");
                System.out.println("    [" + storedTasks[taskIndex - 1].getStatusIcon() + "] " + storedTasks[taskIndex - 1].description);
                printBorder();
                continue;
            }

            if (line.toLowerCase().startsWith("unmark ")) {
                int taskIndex = Integer.parseInt(line.substring(6).trim());
                storedTasks[taskIndex - 1].setDone(false);
                printBorder();
                System.out.println("    OK, I've marked this task as not done yet:");
                System.out.println("    [" + storedTasks[taskIndex - 1].getStatusIcon() + "] " + storedTasks[taskIndex - 1].description);
                printBorder();
                continue;
            }

            storedTasks[taskCount] = new Task(line);
            taskCount++;

            printBorder();
            System.out.println("    added: " + line);
            printBorder();
        }

        printBorder();
        System.out.println("    Bye. Hope to see you again soon!");
        printBorder();
    }

    public static void printBorder() {
        System.out.println("    ____________________________________________________________");
    }
}
