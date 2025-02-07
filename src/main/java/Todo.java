public class Todo extends Task{
    private static final String TYPE = "[T]";

    public Todo(String description) {
        super(description);
    }

    public static void addTodo(Task[] taskList, int taskCount, Parser.CommandResult result) {
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
