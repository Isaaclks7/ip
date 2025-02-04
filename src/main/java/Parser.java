public class Parser {

    public static class CommandResult {
        String command;
        String description;
        String deadline;
        String eventStart;
        String eventEnd;

        public CommandResult(String command, String description, String deadline, String eventStart, String eventEnd) {
            this.command = command;
            this.description = description;
            this.deadline = deadline;
            this.eventStart = eventStart;
            this.eventEnd = eventEnd;
        }
    }

    public static CommandResult extract(String s) {
        String command;
        String description = "";
        String deadline = "";
        String eventStart = "";
        String eventEnd = "";

        if (s.isEmpty()) {
            System.out.println("No command found, please try again.\nCommands available:");
            System.out.println("todo <task description>");
            System.out.println("deadline <task description> /by <deadline>");
            System.out.println("event <task description> /from <start time> /to <end time>");
            return null;
        }

        s = s.trim();
        if (s.contains(" ")) {
            command = s.substring(0, s.indexOf(" "));
            command = command.toLowerCase();
        } else if (s.equalsIgnoreCase("todo") || s.equalsIgnoreCase("deadline") || s.equalsIgnoreCase("event")) {
            System.out.println("Task is missing description");
            return null;
        } else {
            command = s;
            return new CommandResult(command, description, deadline, eventStart, eventEnd);
        }

        //Stores entire substring after the command
        description = s.substring(s.indexOf(" ") + 1);
        if (description.isEmpty()) {
            System.out.println("Task not found, please try again");
            return null;
        }

        switch(command) {
        case "todo":
            description = s.substring(s.indexOf(" ") + 1);
            break;
        case "deadline":
            if (!description.contains("/by") || description.indexOf("/by") == description.length() - 3) {
                System.out.println("    Please add due date:");
                System.out.println("    deadline <task description> /by <due date>");
                return null;
            }
            description = s.substring(s.indexOf(" ") + 1, s.indexOf("/by"));
            deadline = s.substring(s.indexOf("/by") + 4);
            break;
        case "event":
            if (!description.contains("/from") || !description.contains("/to") || description.indexOf("/from") == description.length() - 5 || description.indexOf("/to") == description.length() - 3) {
                System.out.println("    Please add event's start and end time:");
                System.out.println("    event <task description> /from <start time> /to <end time>");
                return null;
            }
            description = s.substring(s.indexOf(" ") + 1, s.indexOf("/from"));
            eventStart = s.substring(s.indexOf("/from") + 6, s.indexOf("/to"));
            eventEnd = s.substring(s.indexOf("/to") + 4);
            break;
        default:
            break;
        }
        return new CommandResult(command, description, deadline, eventStart, eventEnd);
    }
}

