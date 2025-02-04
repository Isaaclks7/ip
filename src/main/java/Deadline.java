public class Deadline extends Task {
    private String deadline;

    private static final String TYPE = "[D]";

    //Constructor
    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
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
