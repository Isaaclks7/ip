public class Parser {
    String command;
    String description;
    String deadline;
    String eventStart;
    String eventEnd;

    public Parser(String command, String description, String deadline, String eventStart, String eventEnd) {
        this.command = command;
        this.description = description;
        this.deadline = deadline;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
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
        System.out.println("      7. End program: bye");
        Ducky.printBorder();
    }

    public static Parser extract(String s) {
        String command;
        String description = "";
        String deadline = "";
        String eventStart = "";
        String eventEnd = "";

        //Ensures input contains task description
        s = s.trim();
        if (s.contains(" ")) {
            command = s.substring(0, s.indexOf(" "));
            command = command.toLowerCase();
        } else if (s.equalsIgnoreCase("todo") || s.equalsIgnoreCase("deadline") || s.equalsIgnoreCase("event")) {
            Ducky.printBorder();
            System.out.println("    Task is missing description");
            Ducky.printBorder();
            return null;
        } else {
            command = s;
            return new Parser(command, description, deadline, eventStart, eventEnd);
        }

        //Stores entire substring after the command
        description = s.substring(s.indexOf(" ") + 1);
        if (description.isEmpty()) {
            Ducky.printBorder();
            System.out.println("    Task not found, please try again");
            Ducky.printBorder();
            return null;
        }

        //Ensures valid command for adding a task
        switch(command) {
        case "todo":
            description = s.substring(s.indexOf(" ") + 1);
            break;
        case "deadline":
            if (!description.contains("/by") || description.indexOf("/by") == description.length() - 3) {
                Ducky.printBorder();
                System.out.println("    Please add due date:");
                System.out.println("    deadline <task description> /by <due date>");
                Ducky.printBorder();
                return null;
            }
            description = s.substring(s.indexOf(" ") + 1, s.indexOf("/by") - 1);
            deadline = s.substring(s.indexOf("/by") + 4);
            break;
        case "event":
            if (!description.contains("/from") || !description.contains("/to") || description.indexOf("/from") == description.length() - 5 || description.indexOf("/to") == description.length() - 3) {
                Ducky.printBorder();
                System.out.println("    Please add event's start and end time:");
                System.out.println("    event <task description> /from <start time> /to <end time>");
                Ducky.printBorder();
                return null;
            }
            description = s.substring(s.indexOf(" ") + 1, s.indexOf("/from"));
            eventStart = s.substring(s.indexOf("/from") + 6, s.indexOf("/to"));
            eventEnd = s.substring(s.indexOf("/to") + 4);
            break;
        default:
            break;
        }
        return new Parser(command, description, deadline, eventStart, eventEnd);
    }
}

