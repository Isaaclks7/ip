import java.util.Scanner;

public class Ducky {
    public static void main(String[] args) {
        printBorder();
        System.out.println("    Hello! I'm Ducky!");
        System.out.println("    What can I do for you?");
        printBorder();

        Scanner in = new Scanner(System.in);
        String line;
        Task[] taskList = new Task[100];
        int taskCount = 0;

        //Handle different commands
        while (true) {
            line = in.nextLine();

            if (line.isEmpty()) {
                continue;
            }

            Parser.CommandResult result = Parser.extract(line);
            if (result == null) {
                continue;
            }

            if (result.command.equals("bye")) {
                break;
            }

            int taskIndex;
            switch (result.command) {
            case "list":
                listAllTasks(taskCount, taskList);
                break;
            case "mark":
                markTask(line, taskCount, taskList);
                break;
            case "unmark":
                unmarkTask(line, taskCount, taskList);
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
                showValidCommands();
                break;
            }
        }
        printBorder();
        System.out.println("    Bye. Hope to see you again soon!");
        printBorder();
    }

    //All methods
    private static void unmarkTask(String line, int taskCount, Task[] taskList) {
        int taskIndex;
        taskIndex = Integer.parseInt(line.substring(6).trim());
        if (taskIndex <= 0 || taskIndex > taskCount) {
            System.out.println("Please enter a valid task index");
            return;
        }
        taskList[taskIndex - 1].setDone(false);
        printBorder();
        System.out.println("    OK, I've marked this task as not done yet:");
        System.out.println("    " + taskList[taskIndex - 1].getType() + "[" + taskList[taskIndex - 1].getStatusIcon() + "] " + taskList[taskIndex - 1].description);
        printBorder();
    }

    private static void markTask(String line, int taskCount, Task[] taskList) {
        int taskIndex;
        taskIndex = Integer.parseInt(line.substring(4).trim());
        if (taskIndex <= 0 || taskIndex > taskCount) {
            System.out.println("Please enter a valid task index");
            return;
        }
        taskList[taskIndex - 1].setDone(true);
        printBorder();
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("    " + taskList[taskIndex - 1].getType() + "[" + taskList[taskIndex - 1].getStatusIcon() + "] " + taskList[taskIndex - 1].description);
        printBorder();
    }

    private static void showValidCommands() {
        printBorder();
        System.out.println("    Invalid command. Please try the following:");
        System.out.println("      1. Add a task: todo <task description>");
        System.out.println("      2. Add task with deadline: deadline <task description> /by <deadline>");
        System.out.println("      3. Add event with start and end times: event <task description> /from <start time> /to <end time>");
        System.out.println("      4. List out all tasks: list");
        System.out.println("      5. Mark a task as done: mark <task index>");
        System.out.println("      6. Unmark a task as undone: unmark <task index>");
        System.out.println("      7. End program: bye");
        printBorder();
    }

    private static void listAllTasks(int taskCount, Task[] taskList) {
        printBorder();
        System.out.println("    Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.print("    " + (i + 1) + "." + taskList[i].getType() + "[" + taskList[i].getStatusIcon() + "] " + taskList[i].description);
            if (taskList[i].getType().equals("[D]")) {
                System.out.println(" (By: " + taskList[i].getDeadline() + ")");
            } else if (taskList[i].getType().equals("[E]")) {
                System.out.println(" (From: " + taskList[i].getEventStart() + " To: " + taskList[i].getEventEnd() + ")");
            } else {
                System.out.println();
            }
        }
        printBorder();
    }

    public static void printBorder() {
        System.out.println("    ____________________________________________________________");
    }
}
