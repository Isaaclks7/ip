package task;

import ducky.Ducky;
import ducky.Parser;
import ducky.Ui;

import java.util.ArrayList;

/**
 * Subclass of Task class to handle Event-type tasks.
 */
public class Todo extends Task{
    private static final String TYPE = "[T]";

    /**
     * Constructor to create new Todo object.
     *
     * @param description The description of the Todo-type task.
     * @param isDone The status of the Todo, whether it is done or not.
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * Returns the Todo object as a String in readable format.
     *
     * @return The Todo's type, status icon, description.
     */
    @Override
    public String toString(){
        return getType() + getStatusIcon() + " " + getDescription();
    }

    /**
     * Adds a Todo object to a list of tasks.
     *
     * @param taskList The list of Tasks to store all the different types of tasks added.
     * @param result Parsed user's input containing Todo details.
     */
    public static void addTodo(ArrayList<Task> taskList, Parser result) {
        taskList.add(new Todo(result.description, false));
        Ui.printBorder();
        System.out.println("    Got it. I've added this Todo:");
        System.out.println("    " + taskList.get(taskList.size()-1).toString());
        System.out.println("    Now you have " + taskList.size() + " tasks in your list.");
        Ui.printBorder();
    }

    /**
     * Gets the task's type as an icon.
     *
     * @return The Event objects icon "[D]".
     */
    @Override
    public String getType() {
        return TYPE;
    }
}
