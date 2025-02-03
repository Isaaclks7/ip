public class Task {
    protected String description;
    protected boolean isDone;
    private static final String TYPE = "[T]";

    public Task() {
        description = "";
        isDone = false;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void setDone(Boolean value) {
        this.isDone = value;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String getType() {
        return TYPE;
    }

    public String getDeadline() {
        return "";
    }

    public String getEventStart() {
        return "";
    }

    public String getEventEnd() {
        return "";
    }
}
