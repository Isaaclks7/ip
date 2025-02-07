public class Deadline extends Task {
    private String deadline;

    private static final String TYPE = "[D]";

    //Constructor
    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    //Add a deadline to the list of tasks
    public static void addDeadline(Task[] taskList, int taskCount, Parser.CommandResult result) {
        taskList[taskCount] = new Deadline(result.description, result.deadline);
        Ducky.printBorder();
        System.out.println("    Got it. I've added this Deadline:");
        System.out.println("      " + taskList[taskCount].getType() + "[ ] " + result.description + " (By: " + result.deadline + ")");
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
