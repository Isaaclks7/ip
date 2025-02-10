import java.util.Scanner;

public class Ducky {
    public static void main(String[] args) {
        printBorder();
        System.out.println("    Hello! I'm Ducky!");
        System.out.println("    What can I do for you?");
        printBorder();

        Scanner in = new Scanner(System.in);
        String line;
        final int LIST_SIZE = 100;
        Task[] taskList = new Task[LIST_SIZE];
        int taskCount = 0;

        //Handle different commands
        while (true) {
            line = in.nextLine();

            if (line.isEmpty()) {
                continue;
            }

            Parser result = Parser.extract(line);
            if (result == null) {
                continue;
            }

            if (result.command.equals("bye")) {
                break;
            }

            int taskIndex;
            switch (result.command) {
            case "list":
                Task.listAllTasks(taskCount, taskList);
                break;
            case "mark":
                Task.markTask(line, taskCount, taskList);
                break;
            case "unmark":
                Task.unmarkTask(line, taskCount, taskList);
                break;
            case "todo":
                Todo.addTodo(taskList, taskCount, result);
                taskCount++;
                break;
            case "deadline":
                Deadline.addDeadline(taskList, taskCount, result);
                taskCount++;
                break;
            case "event":
                Event.addEvent(taskList, taskCount, result);
                taskCount++;
                break;
            default:
                Parser.showValidCommands();
                break;
            }
        }
        printBorder();
        System.out.println("    Bye. Hope to see you again soon!");
        printBorder();
    }

    //Method to print line separator
    public static void printBorder() {
        System.out.println("    ____________________________________________________________");
    }
}
