package task;

import ducky.Ducky;
import ducky.Parser;

import java.util.ArrayList;

public class Deadline extends Task {
    private String deadline;

    private static final String TYPE = "[D]";

    //Constructor
    public Deadline(String description, boolean isDone, String deadline) {
        super(description, isDone);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return getType() + getStatusIcon() + " " + getDescription() + " (By: " + getDeadline() + ")";
    }

    //Add a deadline to the list of tasks
    public static void addDeadline(ArrayList<Task> taskList, Parser result) {
        taskList.add(new Deadline(result.description, false, result.deadline));
        Ducky.printBorder();
        System.out.println("    Got it. I've added this Deadline:");
        System.out.println("      [D]" + "[ ] " + result.description + " (By: " + result.deadline + ")");
        System.out.println("    Now you have " + taskList.size() + " tasks in your list.");
        Ducky.printBorder();
    }

    //Getters and setters
    @Override
    public String getDeadline() {
        return deadline;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
