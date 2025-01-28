import java.util.Scanner;

public class Greet {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm Ducky.");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");

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
                System.out.println("    ____________________________________________________________");
                System.out.println("    Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println("    " + (i + 1) + "." + "[" + storedTasks[i].getStatusIcon()  + "]" + storedTasks[i].description);
                }
                System.out.println("    ____________________________________________________________");
                continue;
            }

            if (line.toLowerCase().startsWith("mark ")) {
                int taskIndex = Integer.parseInt(line.substring(4).trim());
                storedTasks[taskIndex - 1].setDone(true);
                System.out.println("    ____________________________________________________________");
                System.out.println("    Nice! I've marked this task as done:");
                System.out.println("    [" + storedTasks[taskIndex - 1].getStatusIcon() + "] " + storedTasks[taskIndex - 1].description);
                System.out.println("    ____________________________________________________________");
                continue;
            }

            if (line.toLowerCase().startsWith("unmark ")) {
                int taskIndex = Integer.parseInt(line.substring(6).trim());
                storedTasks[taskIndex - 1].setDone(false);
                System.out.println("    ____________________________________________________________");
                System.out.println("    OK, I've marked this task as not done yet:");
                System.out.println("    [" + storedTasks[taskIndex - 1].getStatusIcon() + "] " + storedTasks[taskIndex - 1].description);
                System.out.println("    ____________________________________________________________");
                continue;
            }

            storedTasks[taskCount] = new Task(line);
            storedTasks[taskCount].description = line;
            taskCount++;

            System.out.println("    ____________________________________________________________");
            System.out.println("    added: " + line);
            System.out.println("    ____________________________________________________________");
        }

        System.out.println("    ____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }
}
