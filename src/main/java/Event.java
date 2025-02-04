public class Event extends Task {
    private String eventStart;
    private String eventEnd;
    private static final String TYPE = "[E]";

    //Constructor
    public Event(String description, String startTime, String endTime) {
        super(description);
        this.eventStart = startTime;
        this.eventEnd = endTime;
    }

    //Getters and setters
    @Override
    public String getEventStart() {
        return eventStart;
    }

    @Override
    public String getEventEnd() {
        return eventEnd;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
