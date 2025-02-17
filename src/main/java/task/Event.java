package task;

import ducky.Ducky;
import ducky.Parser;

import java.util.ArrayList;

public class Event extends Task {
    private String eventStart;
    private String eventEnd;
    private static final String TYPE = "[E]";

    //Constructor
    public Event(String description, boolean isDone, String startTime, String endTime) {
        super(description, isDone);
        this.eventStart = startTime;
        this.eventEnd = endTime;
    }

    @Override
    public String toString(){
        return getType() + getStatusIcon() + " " + getDescription() + " (From: " + getEventStart() + " To: " + getEventEnd() + ")";
    }

    //Add an event to the list of tasks
    public static void addEvent(ArrayList<Task> taskList, Parser result) {
        taskList.add(new Event(result.description, false, result.eventStart, result.eventEnd));
        Ducky.printBorder();
        System.out.println("    Got it. I've added this Event:");
        System.out.println("      [E]" + "[ ] " + result.description + " (From: " + result.eventStart + " To: " + result.eventEnd + ")");
        System.out.println("    Now you have " + taskList.size() + " tasks in your list.");
        Ducky.printBorder();
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
