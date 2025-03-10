package ducky;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Parser class manages user's input.
 */
public class Parser {
    public String command;
    public String description;
    public String deadline;
    public String eventStart;
    public String eventEnd;

    public Parser(String command, String description, String deadline, String eventStart, String eventEnd) {
        this.command = command;
        this.description = description;
        this.deadline = deadline;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
    }

    /**
     * Extracts the command details from {@code userInput}.
     *
     * @param userInput Contains command details.
     * @return Parser object which contains each extracted command details.
     */
    public static Parser extract(String userInput) {
        String command = "";
        String description = "";
        String deadline = "";
        String eventStart = "";
        String eventEnd = "";

        userInput = userInput.trim();

        //extract command from user input
        try {
            command = userInput.substring(0, userInput.indexOf(" "));
            command = command.toLowerCase();
        } catch (Exception e) {
            command = userInput;
        }

        //Ensures valid command for adding a task
        switch(command) {
        case "todo":
            try {
                description = userInput.substring(userInput.indexOf(" "));
                description = description.trim();
            } catch (Exception e) {
                DuckyException.printTodoError();
                return null;
            }
            break;
        case "deadline":
            try {
                description = userInput.substring(userInput.indexOf(" ") + 1, userInput.indexOf("/by") - 1);
                deadline = userInput.substring(userInput.indexOf("/by") + 4);
                try {
                    LocalDate date = LocalDate.parse(deadline);
                    deadline = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
                } catch (Exception e) {
                    break;
                }
            } catch (Exception e) {
                DuckyException.printDeadlineError();
                return null;
            }
            break;
        case "event":
            try {
                description = userInput.substring(userInput.indexOf(" ") + 1, userInput.indexOf("/from"));
                eventStart = userInput.substring(userInput.indexOf("/from") + 6, userInput.indexOf("/to"));
                eventEnd = userInput.substring(userInput.indexOf("/to") + 4);
            } catch (Exception e) {
                DuckyException.printEventError();
                return null;
            }
            break;
        }
        return new Parser(command, description, deadline, eventStart, eventEnd);
    }
}

