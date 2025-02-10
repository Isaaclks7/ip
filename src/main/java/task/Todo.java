package task;

import ducky.Ducky;
import ducky.Parser;

public class Todo extends Task{
    private static final String TYPE = "[T]";

    public Todo(String description) {
        super(description);
    }

    //Add a to-do to a list of tasks
    public static void addTodo(Task[] taskList, int taskCount, Parser result) {
        taskList[taskCount] = new Todo(result.description);
        Ducky.printBorder();
        System.out.println("    Got it. I've added this Todo:");
        System.out.println("      " + taskList[taskCount].getType() + "[ ] " + result.description);
        System.out.println("    Now you have " + (taskCount +1) + " tasks in your list.");
        Ducky.printBorder();
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
