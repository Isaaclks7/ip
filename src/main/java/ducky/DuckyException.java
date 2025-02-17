package ducky;

public class DuckyException extends Exception {
    public DuckyException(String message) {
        super(message);
    }

    public static void showValidCommands() {
        Ducky.printBorder();
        System.out.println("    Invalid command. Please try the following:");
        System.out.println("      1. Add a task: todo <task description>");
        System.out.println("      2. Add task with deadline: deadline <task description> /by <deadline>");
        System.out.println("      3. Add event with start and end times: event <task description> /from <start time> /to <end time>");
        System.out.println("      4. List out all tasks: list");
        System.out.println("      5. Mark a task as done: mark <task index>");
        System.out.println("      6. Unmark a task as undone: unmark <task index>");
        System.out.println("      7. Delete a task: delete <task index>");
        System.out.println("      8. End program: bye");

        Ducky.printBorder();
    }

    public static void printDeadlineError() {
        Ducky.printBorder();
        System.out.println("    Please add due date:");
        System.out.println("    deadline <task description> /by <due date>");
        Ducky.printBorder();
    }

    public static void printEventError() {
        Ducky.printBorder();
        System.out.println("    Please add event's start and end time:");
        System.out.println("    event <task description> /from <start time> /to <end time>");
        Ducky.printBorder();
    }

    public static void printTodoError() {
        Ducky.printBorder();
        System.out.println("    Please add Todo's description:");
        System.out.println("    todo <task description>");
        Ducky.printBorder();
    }
}
