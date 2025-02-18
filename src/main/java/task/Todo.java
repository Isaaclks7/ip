package task;

import ducky.Ducky;
import ducky.Parser;

import java.util.ArrayList;

public class Todo extends Task{
    private static final String TYPE = "[T]";

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toString(){
        return getType() + getStatusIcon() + " " + getDescription();
    }

    //Add a to-do to a list of tasks
    public static void addTodo(ArrayList<Task> taskList, Parser result) {
        taskList.add(new Todo(result.description, false));
        Ducky.printBorder();
        System.out.println("    Got it. I've added this Todo:");
        System.out.println("      [T]" + "[ ] " + result.description);
        System.out.println("    Now you have " + taskList.size() + " tasks in your list.");
        Ducky.printBorder();
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
