package task;

import ducky.Ducky;
import ducky.Parser;
import ducky.Ui;

import java.util.ArrayList;

/**
 * Subclass of Task class to handle Deadline-type tasks.
 */
public class Deadline extends Task {
    private String deadline;

    private static final String TYPE = "[D]";

    /**
     * Constructor that creates a new Deadline object
     *
     * @param description The description of the deadline.
     * @param isDone The status of the deadline, whether it is marked as done or not.
     * @param deadline The due date/time of the deadline specified.
     */
    public Deadline(String description, boolean isDone, String deadline) {
        super(description, isDone);
        this.deadline = deadline;
    }

    /**
     * Returns the Deadline object as a String in readable format.
     *
     * @return The Deadline's type, status icon, description and due date/time.
     */
    @Override
    public String toString() {
        return getType() + getStatusIcon() + " " + getDescription() + " (By: " + getDeadline() + ")";
    }

    /**
     * Adds a Deadline object to a list of Tasks.
     * @param taskList The list of Tasks to store all the different types of tasks added.
     * @param result Parsed user's input which contains deadline details.
     */
    public static void addDeadline(ArrayList<Task> taskList, Parser result) {
        taskList.add(new Deadline(result.description, false, result.deadline));
        Ui.printBorder();
        System.out.println("    Got it. I've added this Deadline:");
        System.out.println("    " + taskList.get(taskList.size()-1).toString());
        System.out.println("    Now you have " + taskList.size() + " tasks in your list.");
        Ui.printBorder();
    }

    /**
     * Gets due date/time of the deadline.
     *
     * @return The due date/time of the deadline object.
     */
    @Override
    public String getDeadline() {
        return deadline;
    }

    /**
     * Gets the task's type as an icon.
     *
     * @return The Deadline objects icon "[D]".
     */
    @Override
    public String getType() {
        return TYPE;
    }
}
