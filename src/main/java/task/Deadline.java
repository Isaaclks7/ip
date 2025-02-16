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

    //Add a deadline to the list of tasks
    public static void addDeadline(ArrayList<Task> taskList, int taskCount, Parser result) {
        taskList.add(new Deadline(result.description, false, result.deadline));
        Ducky.printBorder();
        System.out.println("    Got it. I've added this Deadline:");
        System.out.println("      " + taskList.get(taskCount).getType() + "[ ] " + result.description + " (By: " + result.deadline + ")");
        System.out.println("    Now you have " + (taskCount +1) + " tasks in your list.");
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
