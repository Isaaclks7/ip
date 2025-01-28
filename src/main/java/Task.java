public class Task {
    protected String description;
    protected boolean isDone;

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
}
